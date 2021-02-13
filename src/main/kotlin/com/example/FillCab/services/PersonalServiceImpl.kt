package com.example.FillCab.services

import com.example.FillCab.models.PersonalCard
import com.example.FillCab.repository.IPersonalCardRepository
import org.springframework.stereotype.Service
import java.util.*

/**
 * Реализация сервиса Работника(выносим логику из контроллеров),
 * переопредены методы поиска, сохранения, удаления.
 * При дальнейшем усложнении логики, и развитии веб-приложения - наличие сервиса будет оправдано.
 */

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
    fun findBySurnameIgnoreCase(surname: String): Iterable<PersonalCard> {
        return personalCardRepository.findBySurnameIgnoreCase(surname)
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