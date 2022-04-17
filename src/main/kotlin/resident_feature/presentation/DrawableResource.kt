package resident_feature.presentation

sealed class DrawableResource(val resource: String){
 object TrailingIconUp: DrawableResource(resource = "ic_trailing_icon_up.svg")
 object TrailingIconDown: DrawableResource(resource = "ic_trailing_icon_down.svg")
 object ProfilePlaceHolder: DrawableResource(resource = "profile_placeholder.jpg")
}
