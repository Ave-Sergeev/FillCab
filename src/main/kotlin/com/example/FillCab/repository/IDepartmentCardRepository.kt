package com.example.FillCab.repository

import com.example.FillCab.models.DepartmentCard
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Репозиторий Отдела.
 */

@Repository
interface IDepartmentCardRepository : CrudRepository<DepartmentCard, Long>

