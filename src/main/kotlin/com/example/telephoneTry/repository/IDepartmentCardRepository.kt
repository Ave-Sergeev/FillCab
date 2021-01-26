package com.example.telephoneTry.repository

import com.example.telephoneTry.models.DepartmentCard
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IDepartmentCardRepository : CrudRepository<DepartmentCard, Long>
