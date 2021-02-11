package com.example.FillCab.controllers

import com.example.FillCab.models.PersonalCard
import com.example.FillCab.services.DepartmentServiceImpl
import com.example.FillCab.services.PersonalServiceImpl
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class CreateController (val personalServiceImpl: PersonalServiceImpl,
                        val departmentServiceImpl: DepartmentServiceImpl) {

    //Получаем инфу при создании карточки работника, и обновляем данные на filingCabinetPage
    @PostMapping("/createPersonPage")
    fun updatedListOfPerson(@ModelAttribute("person") person: PersonalCard,
                            model: MutableMap<String, Any?>): String {
        personalServiceImpl.save(person)
        model["personsList"] = personalServiceImpl.findAll()

        return "redirect:/"
    }

    //Отдаем страницу Создания карточки работника
    @GetMapping("/createPersonPage")
    fun createPersonShow(@ModelAttribute("person") person: PersonalCard?,
                         model: Model): String {
        model["departmentsList"] = departmentServiceImpl.findAll()

        return "createPersonPage"
    }
}

