package com.example.telephoneTry.services

import com.example.telephoneTry.models.DepartmentCard
import com.example.telephoneTry.repository.IDepartmentCardRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DepartmentServiceImpl (val departmentCardRepository: IDepartmentCardRepository): IBaseService<DepartmentCard> {
    override fun findAll(): Iterable<DepartmentCard> {
        return departmentCardRepository.findAll()
    }

    override fun save(depart: DepartmentCard) {
        departmentCardRepository.save(depart)
    }

    override fun delete(depart: DepartmentCard) {
        departmentCardRepository.delete(depart)
    }

    //Переопределяем из репозитория
    fun findById(id: Long): Optional<DepartmentCard> {
        return departmentCardRepository.findById(id)
    }

    //Удаляем по id
    override fun deleteById(id: Long) {
        return departmentCardRepository.deleteById(id)
    }
}






