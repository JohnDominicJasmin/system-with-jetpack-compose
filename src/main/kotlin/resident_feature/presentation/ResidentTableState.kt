package resident_feature.presentation

import resident_feature.domain.model.Resident
import resident_feature.domain.util.OrderType

data class ResidentTableState(

    val residents: List<Resident> = emptyList(),
    val columnOrder: OrderType? = null,
    )