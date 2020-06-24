package no.systek.graphqlworkshop.storage

import org.springframework.stereotype.Repository

@Repository
class DishRepository {
    private val exampleData = arrayListOf<Dish>(
            Dish(0, "Typer of Code", mutableListOf<Ingredient>(
                    Ingredient(1,"cheese"),
                    Ingredient(2,"tomatoes"),
                    Ingredient(3,"flour")
            )),
        Dish(1, "Cookie", emptyList<Ingredient>()),
        Dish(2, "Snacks", emptyList<Ingredient>())
    )

    fun getAll() = exampleData

    fun getDish(id: Int) : Dish {
        return exampleData.get(id)
    }
    fun addDish(name: String): Dish {
        exampleData.add(Dish(id = exampleData.size, name = name, ingredients = listOf()))
        return exampleData.last()
    }
}
