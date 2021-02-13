package com.example.FillCab.repository

import com.example.FillCab.models.PersonalCard
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Репозиторий Работника, реализован поиск по имени игнорируя регистр
 */

@Repository
interface IPersonalCardRepository : CrudRepository<PersonalCard, Long> {
    fun findBySurnameIgnoreCase(name: String): Iterable<PersonalCard>
}
