package no.systek.graphqlworkshop.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import no.systek.graphqlworkshop.storage.DishRepository
import org.springframework.stereotype.Component

@Component
class RootMutationResolver(private val dishRepository: DishRepository) : GraphQLMutationResolver {
    fun addDish(name:String) = dishRepository.addDish(name)
}
