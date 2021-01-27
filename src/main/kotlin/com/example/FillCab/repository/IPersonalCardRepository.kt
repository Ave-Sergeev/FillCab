package com.example.FillCab.repository

import com.example.FillCab.models.PersonalCard
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IPersonalCardRepository : CrudRepository<PersonalCard, Long> {
    //Найти по имени игнорируя регистр
    fun findBySurnameIgnoreCase(name: String): Iterable<PersonalCard>
}
