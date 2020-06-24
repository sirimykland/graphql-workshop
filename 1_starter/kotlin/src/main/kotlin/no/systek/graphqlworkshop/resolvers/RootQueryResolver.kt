package no.systek.graphqlworkshop.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import no.systek.graphqlworkshop.storage.DishRepository
import no.systek.graphqlworkshop.storage.PersonRepository
import org.springframework.stereotype.Component

@Component
class RootQueryResolver(private val personRepository: PersonRepository, private val dishRepository: DishRepository) : GraphQLQueryResolver {
    fun getDevelopers() = personRepository.getAll()
    fun getDishes() = dishRepository.getAll()
    fun getDish(id: Int) = dishRepository.getDish(id)
}
