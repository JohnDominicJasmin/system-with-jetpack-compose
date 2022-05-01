package resident_feature.util

sealed class DrawableResource(val resource: String){
 object TrailingIconUp: DrawableResource(resource = "system_resources/ic_trailing_icon_up.svg")
 object TrailingIconDown: DrawableResource(resource = "system_resources/ic_trailing_icon_down.svg")
 object ProfilePlaceHolder: DrawableResource(resource = "system_resources/profile_placeholder.jpg")
 object SortIcon: DrawableResource(resource = "system_resources/ic_sort_icon.svg")
 object ToggleSortIcon: DrawableResource(resource = "system_resources/ic_toggle_sort_icon.svg")
 object EditIcon: DrawableResource(resource = "system_resources/ic_pen.svg")
 object DeleteIcon: DrawableResource(resource = "system_resources/ic_trash.svg")
 object SuccessIcon: DrawableResource(resource = "system_resources/ic_success.svg")
 object FailedIcon: DrawableResource(resource = "system_resources/ic_error.svg")
 object WarningIcon: DrawableResource(resource = "system_resources/ic_warning.svg")
}
