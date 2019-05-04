package hossein.gheisary.recycleview.itemanimators

class AlphaCrossFadeAnimator : DefaultAnimator<AlphaCrossFadeAnimator>() {

    override fun getAddDelay(remove: Long, move: Long, change: Long): Long {
        return 0
    }

    override fun getRemoveDelay(remove: Long, move: Long, change: Long): Long {
        return remove / 2
    }
}
