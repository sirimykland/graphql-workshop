package no.systek.graphqlworkshop.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import kotlinx.coroutines.runBlocking
import no.systek.graphqlworkshop.clients.MarketPriceClient
import no.systek.graphqlworkshop.storage.DataSource
import no.systek.graphqlworkshop.storage.Dish
import no.systek.graphqlworkshop.storage.Ingredient
import no.systek.graphqlworkshop.storage.Order
import no.systek.graphqlworkshop.storage.OrderIngredientsBy
import no.systek.graphqlworkshop.storage.OrderIngredientsBy.NAME
import no.systek.graphqlworkshop.storage.OrderIngredientsBy.PRICE
import org.springframework.stereotype.Component

@Component
class QueryResolver(
    private val dataSource: DataSource,
    private val marketPriceClient: MarketPriceClient
) : GraphQLQueryResolver {
    suspend fun dishes(): Collection<Dish> = dataSource.dishes

    suspend fun dish(dishId: Long): Dish = dataSource.getDish(dishId)

    suspend fun orders(): Collection<Order> = dataSource.orders

    suspend fun ingredients(orderBy: OrderIngredientsBy?): List<Ingredient> =
        when (orderBy) {
            NAME -> dataSource.ingredients.sortedBy { it.name }
            PRICE -> dataSource.ingredients
                .sortedBy { runBlocking { marketPriceClient.getMarketPrice(it.name).price } }
            else -> dataSource.ingredients.toList()
        }
}
