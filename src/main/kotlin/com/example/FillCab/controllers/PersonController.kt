package com.example.FillCab.controllers

import com.example.FillCab.models.PersonalCard
import com.example.FillCab.services.DepartmentServiceImpl
import com.example.FillCab.services.PersonalServiceImpl
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class PersonController(val personalServiceImpl: PersonalServiceImpl,
                       val departmentServiceImpl: DepartmentServiceImpl) {

    //Отдаем главную страницу(filingCabinetPage)
    @GetMapping()
    fun filingCabinetShow(model: MutableMap<String, Any?>): String {
        model["personsList"] = personalServiceImpl.findAll()
        return "filingCabinetPage"
    }

    //Отдаем главную страницу(filingCabinetPage) после удаления работника
    @GetMapping("/delete/{id}")
    fun deletePersonShow(@PathVariable("id") id: Long,
                         model: Model?): String {
        val person = personalServiceImpl.findById(id).orElseThrow{IllegalArgumentException("Invalid user Id:$id")}
        personalServiceImpl.delete(person)
        return "redirect:/"
    }

    //Получаем инфу при правке карточки работника, и обновляем данные на filingCabinetPage
    @PostMapping("/update/{id}")
    fun updatePerson(@PathVariable("id") id: Long,
                     person: PersonalCard,
                     result: BindingResult,
                     model: Model?): String {
        personalServiceImpl.save(person)
        return "redirect:/"
    }

    //Отдаем страницу Правки карточки работника
    @GetMapping("/edit/{id}")
    fun redactPersonShow(@PathVariable("id") id: Long, model: Model): String {
        val person = personalServiceImpl.findById(id).orElseThrow{IllegalArgumentException("Invalid user Id:$id")}
        model["departmentsList"] = departmentServiceImpl.findAll()
        model["person"] = person
        return "updatePersonPage"
    }
}



















