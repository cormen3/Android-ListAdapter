package hossein.gheisary.recycleview.itemanimators

import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class SlideInOutLeftAnimator(private val mRecyclerView: RecyclerView) : DefaultAnimator<SlideInOutLeftAnimator>() {

    private var mDeltaX: Float = 0.toFloat()

    override fun addAnimationPrepare(holder: RecyclerView.ViewHolder) {
        retrieveItemPosition(holder)
        ViewCompat.setTranslationX(holder.itemView, -mDeltaX)
        ViewCompat.setTranslationZ(holder.itemView, 100f)
    }

    override fun addAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        val view = holder.itemView
        return ViewCompat.animate(view).translationX(0f).alpha(1f).setDuration(addDuration)
    }

    override fun addAnimationCleanup(holder: RecyclerView.ViewHolder) {
        ViewCompat.setAlpha(holder.itemView, 1f)
        ViewCompat.setTranslationX(holder.itemView, 0f)
        ViewCompat.setTranslationZ(holder.itemView, 1f)
    }

    override fun removeAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        ViewCompat.setTranslationZ(holder.itemView, 100f)
        val animation = ViewCompat.animate(holder.itemView)
        return animation.setDuration(removeDuration).alpha(0f).translationX(-mDeltaX)
    }

    override fun removeAnimationCleanup(holder: RecyclerView.ViewHolder) {
        ViewCompat.setTranslationX(holder.itemView, 0f)
        ViewCompat.setAlpha(holder.itemView, 1f)
        ViewCompat.setTranslationZ(holder.itemView, 1f)
    }


    private fun retrieveItemPosition(holder: RecyclerView.ViewHolder) {
        mDeltaX = (mRecyclerView.width - mRecyclerView.layoutManager!!.getDecoratedLeft(holder.itemView)).toFloat()
    }

    override fun getAddDelay(remove: Long, move: Long, change: Long): Long {
        return 0
    }

    override fun getRemoveDelay(remove: Long, move: Long, change: Long): Long {
        return remove / 2
    }

}
