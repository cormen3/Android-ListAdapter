package hossein.gheisary.recycleview.itemanimators

import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

abstract class BaseScaleAnimator<T> : BaseItemAnimator<T>() {
    override fun changeAnimation(
        oldHolder: RecyclerView.ViewHolder,
        newHolder: RecyclerView.ViewHolder?,
        fromX: Int,
        fromY: Int,
        toX: Int,
        toY: Int
    ) {
        val prevTranslationX = ViewCompat.getTranslationX(oldHolder.itemView)
        val prevTranslationY = ViewCompat.getTranslationY(oldHolder.itemView)
        val prevValue = changeAnimationPrepare1(oldHolder)
        resetAnimation(oldHolder)
        val deltaX = (toX.toFloat() - fromX.toFloat() - prevTranslationX).toInt()
        val deltaY = (toY.toFloat() - fromY.toFloat() - prevTranslationY).toInt()
        // recover prev translation state after ending animation
        ViewCompat.setTranslationX(oldHolder.itemView, prevTranslationX)
        ViewCompat.setTranslationY(oldHolder.itemView, prevTranslationY)

        changeAnimationPrepare2(oldHolder, prevValue)
        if (newHolder != null) {
            // carry over translation values
            resetAnimation(newHolder)
            ViewCompat.setTranslationX(newHolder.itemView, (-deltaX).toFloat())
            ViewCompat.setTranslationY(newHolder.itemView, (-deltaY).toFloat())
            changeAnimationPrepare3(newHolder)
        }
    }

    abstract fun changeAnimationPrepare1(holder: RecyclerView.ViewHolder): Float

    abstract fun changeAnimationPrepare2(holder: RecyclerView.ViewHolder, prevValue: Float)

    abstract fun changeAnimationPrepare3(holder: RecyclerView.ViewHolder)
}
