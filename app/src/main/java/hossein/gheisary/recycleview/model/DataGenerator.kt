package hossein.gheisary.recycleview.model

class DataGenerator {
    private val post1 = ListItem("Item 1")
    private val post2 = ListItem("item 2")
    private val post3 = ListItem("Item 3")
    private val post4 = ListItem("Item 4")
    private val post5 = ListItem("Item 5")
    private val post6 = ListItem("Item 6")
    private val post7 = ListItem("Item 7")
    private val post8 = ListItem("Item 8")
    private val post9 = ListItem("Item 9")
    private val post10 = ListItem("Item 10")

    companion object {
        fun get(): List<ListItem> {
            return DataGenerator().getPostList()
        }
    }

    private fun getPostList() = when ((0..5).shuffled().first()) {
        0 -> getPostList0()
        1 -> getPostList1()
        2 -> getPostList2()
        3 -> getPostList3()
        4 -> getPostList4()
        5 -> getPostList5()
        6 -> getPostList6()
        else -> getPostListAll()
    }

    private fun getPostList0(): List<ListItem> {
        return mutableListOf(post2, post3, post4, post5, post6, post7, post8)
    }

    private fun getPostList1(): List<ListItem> {
        return mutableListOf( post3, post4, post5, post6, post7, post8)
    }

    private fun getPostList2(): List<ListItem> {
        return mutableListOf(post2, post3, post4, post6, post7, post8)
    }

    private fun getPostList3(): List<ListItem> {
        return mutableListOf( post3, post4, post5, post7, post8)
    }

    private fun getPostList4(): List<ListItem> {
        return mutableListOf( post3, post4, post5, post6, post7)
    }

    private fun getPostList5(): List<ListItem> {
        return mutableListOf( post4, post5, post6, post7, post8)
    }

    private fun getPostList6(): List<ListItem> {
        return mutableListOf(post2, post3, post4, post5, post6, post7, post8)
    }

    private fun getPostListAll(): List<ListItem> {
        return mutableListOf(post2, post3, post4, post5, post6)
    }
}