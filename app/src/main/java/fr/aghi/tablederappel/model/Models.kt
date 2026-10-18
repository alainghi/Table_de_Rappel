package fr.aghi.tablederappel.model

data class Item(
    val mot: String,
    val numero: String
)

data class TBNombreItem(
    val numero: String,
    val mot: String,
    val image: String
)

data class JsonResponse(
    val items: Map<String, Item>
)

data class TBNombreResponse(
    val items: Map<String, TBNombreItem>
) 