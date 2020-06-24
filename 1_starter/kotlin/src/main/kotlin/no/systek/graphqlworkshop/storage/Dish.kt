package no.systek.graphqlworkshop.storage

class Dish(val id:Int, var name:String, var ingredients: List<Ingredient>? = null)