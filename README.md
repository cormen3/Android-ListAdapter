# Android-ListAdapter
 It is simple usage of ListAdapter in Android. 
 ListAdapter is a new class bundled in the 27.1.0 support library and simplifies the code required to work with RecyclerViews. The end result is less code for you to write and more recycler view animations happening for free.
 
 
Why is it great? It’s great because it automatically stores the previous list of items and utilises DiffUtil under the hood to only update items in the recycler view which have changed. This typically means better performance as you avoid refreshing the whole list, and nicer animations because only items which change need to be redrawn.


If you are still using notifyDataSetChanged() then you are forcing the entire list to be redrawn and therefore not allowing Android the chance to show nice visual cues to the user as to what exactly just changed. Instead of reloading the entire list, you can use methods like notifyItemInserted, notifyItemChanged and notifyItemRemoved. These result in lovely animations but working out which method to invoke manually is non-trivial.


ListAdapter helps you by calculating which methods to invoke out of inserted/changed/removed.
