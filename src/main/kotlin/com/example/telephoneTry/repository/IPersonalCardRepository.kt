package com.example.telephoneTry.repository

import com.example.telephoneTry.models.PersonalCard
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IPersonalCardRepository : CrudRepository<PersonalCard, Long> {
    //Найти по имени игнорируя регистр
    fun findByNameIgnoreCase(name: String): Iterable<PersonalCard>
}
