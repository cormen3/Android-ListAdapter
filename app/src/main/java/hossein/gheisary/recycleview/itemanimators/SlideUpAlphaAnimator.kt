package hossein.gheisary.recycleview.itemanimators

import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorCompat
import androidx.recyclerview.widget.RecyclerView

class SlideUpAlphaAnimator : DefaultAnimator<SlideUpAlphaAnimator>() {
    override fun addAnimationPrepare(holder: RecyclerView.ViewHolder) {
        ViewCompat.setTranslationY(holder.itemView, holder.itemView.height.toFloat())
        ViewCompat.setAlpha(holder.itemView, 0f)
    }

    override fun addAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        return ViewCompat.animate(holder.itemView).translationY(0f).alpha(1f).setDuration(moveDuration)
            .setInterpolator(interpolator)
    }

    override fun addAnimationCleanup(holder: RecyclerView.ViewHolder) {
        ViewCompat.setTranslationY(holder.itemView, 0f)
        ViewCompat.setAlpha(holder.itemView, 1f)
    }

    override fun getAddDelay(remove: Long, move: Long, change: Long): Long {
        return 0
    }

    override fun getRemoveDelay(remove: Long, move: Long, change: Long): Long {
        return 0
    }

    override fun removeAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        val animation = ViewCompat.animate(holder.itemView)
        return animation.setDuration(removeDuration).alpha(0f).translationY(holder.itemView.height.toFloat())
            .setInterpolator(interpolator)
    }

    override fun removeAnimationCleanup(holder: RecyclerView.ViewHolder) {
        ViewCompat.setTranslationY(holder.itemView, 0f)
        ViewCompat.setAlpha(holder.itemView, 1f)
    }
}
