package resident_feature.util

sealed class DrawableResource(val resource: String){
 object TrailingIconUp: DrawableResource(resource = "ic_trailing_icon_up.svg")
 object TrailingIconDown: DrawableResource(resource = "ic_trailing_icon_down.svg")
 object ProfilePlaceHolder: DrawableResource(resource = "profile_placeholder.jpg")
 object SortIcon: DrawableResource(resource = "ic_sort_icon.svg")
 object ToggleSortIcon: DrawableResource(resource = "ic_toggle_sort_icon.svg")
 object EditIcon: DrawableResource(resource = "ic_pen.svg")
 object DeleteIcon: DrawableResource(resource = "ic_trash.svg")

}
