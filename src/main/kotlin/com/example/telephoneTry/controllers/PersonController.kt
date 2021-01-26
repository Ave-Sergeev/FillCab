package com.example.telephoneTry.controllers

import com.example.telephoneTry.models.PersonalCard
import com.example.telephoneTry.services.DepartmentServiceImpl
import com.example.telephoneTry.services.PersonalServiceImpl
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

    //Отдаем страницу Поиска работника
    @GetMapping("/searchPersonPage{name}")
    fun searchPersonShow(@RequestParam(value = "name", required = false) name: String,
                         model: MutableMap<String, Any?>): String {
        val allSearchName: Iterable<PersonalCard> = personalServiceImpl.findByNameIgnoreCase(name)
        model["personsList"] = allSearchName
        model["name"] = name
        return "searchPersonPage"
    }

    //Отдаем страницу Правки карточки работника
    @GetMapping("/edit/{id}")
    fun redactPersonShow(@PathVariable("id") id: Long, model: Model): String {
        val person = personalServiceImpl.findById(id).orElseThrow{IllegalArgumentException("Invalid user Id:$id")}
        model["departmentsList"] = departmentServiceImpl.findAll()
        model["person"] = person
        return "updatePersonPage"
    }

    //Отдаем filingCabinetPage после удаления работника
    @GetMapping("/delete/{id}")
    fun deletePersonShow(@PathVariable("id") id: Long, model: Model?): String {
        val person = personalServiceImpl.findById(id).orElseThrow{IllegalArgumentException("Invalid user Id:$id")}
        personalServiceImpl.delete(person)
        return "redirect:/"
    }

    //Отдаем страницу Создания карточки работника
    @GetMapping("/createPersonPage")
    fun createPersonShow(@ModelAttribute("person") person: PersonalCard?,
                         model: Model): String {
        model["departmentsList"] = departmentServiceImpl.findAll()
        return "createPersonPage"
    }

    //Получаем инфу при создании карточки работника, и обновляем данные на filingCabinetPage
    @PostMapping("/createPersonPage")
    fun updatedListOfPerson(@ModelAttribute("person") person: PersonalCard,
                                model: MutableMap<String, Any?>): String {
        personalServiceImpl.save(person)
        model["personsList"] = personalServiceImpl.findAll()
        return "redirect:/"
    }

    //Получаем инфу при правке карточки работника, и обновляем данные на filingCabinetPage
    @PostMapping("/update/{id}")
    fun updatePerson(@PathVariable("id") id: Long, person: PersonalCard,
                     result: BindingResult, model: Model?): String {
        personalServiceImpl.save(person)
        return "redirect:/"
    }
}


















