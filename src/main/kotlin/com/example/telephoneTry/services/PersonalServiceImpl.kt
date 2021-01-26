package com.example.telephoneTry.services

import com.example.telephoneTry.models.PersonalCard
import com.example.telephoneTry.repository.IPersonalCardRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonalServiceImpl(val personalCardRepository: IPersonalCardRepository): IBaseService<PersonalCard>  {
    override fun findAll(): Iterable<PersonalCard> {
        return personalCardRepository.findAll()
    }

    override fun save(person: PersonalCard) {
        personalCardRepository.save(person)
    }

    override fun delete(person: PersonalCard) {
        personalCardRepository.delete(person)
    }

    //Переопределяем из репозитория
    fun findByNameIgnoreCase(name: String): Iterable<PersonalCard> {
        return personalCardRepository.findByNameIgnoreCase(name)
    }

    //Переопределяем из репозитория
    fun findById(id: Long): Optional<PersonalCard> {
        return personalCardRepository.findById(id)
    }

    //Удаляем по id
    override fun deleteById(id: Long) {
        return personalCardRepository.deleteById(id)
    }
}