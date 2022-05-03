package resident_feature.util

sealed class DrawableResource(val resource: String){
 object TrailingIconUp: DrawableResource(resource = "system_resources/ic_trailing_icon_up.svg")
 object TrailingIconDown: DrawableResource(resource = "system_resources/ic_trailing_icon_down.svg")
 object ProfilePlaceHolder: DrawableResource(resource = "system_resources/profile_placeholder.jpg")

 object SortIconDescending: DrawableResource(resource = "system_resources/ic_sort_down.svg")
 object SortIconAscending: DrawableResource(resource = "system_resources/ic_sort_up.svg")

 object ToggledIcon: DrawableResource(resource = "system_resources/ic_toggle_up.svg")
 object NotToggledIcon: DrawableResource(resource = "system_resources/ic_toggle_down.svg")

 object EditIcon: DrawableResource(resource = "system_resources/ic_pen.svg")
 object DeleteIcon: DrawableResource(resource = "system_resources/ic_trash.svg")
 object SuccessIcon: DrawableResource(resource = "system_resources/ic_success.svg")
 object ErrorIcon: DrawableResource(resource = "system_resources/ic_error.svg")
 object WarningIcon: DrawableResource(resource = "system_resources/ic_warning.svg")
 object QuestionIcon: DrawableResource(resource = "system_resources/ic_question.svg")
 object NoImageFound: DrawableResource(resource = "system_resources/ic_no_image_found.jpg")
}
