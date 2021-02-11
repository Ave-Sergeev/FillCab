package com.example.FillCab.controllers

import com.example.FillCab.models.DepartmentCard
import com.example.FillCab.services.DepartmentServiceImpl
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
class DepartmentController(val departmentServiceImpl: DepartmentServiceImpl) {

    //Отдаем страницу действий с Подразделениями
    @GetMapping("/actionDepartPage")
    fun actionsWithDepartmentShow(@ModelAttribute("createDepart") depart: DepartmentCard?,
                                  model: Model): String {
        model["departmentsList"] = departmentServiceImpl.findAll()

        return "actionDepartPage"
    }

    //Получаем инфу с страницы подразделения, сохраняем созданное подразделение
    @PostMapping("/actionDepartPage")
    fun createDepartment(@ModelAttribute("createDepart") depart: DepartmentCard): String {
        departmentServiceImpl.save(depart)

        return "redirect:/"
    }

    //Получаем инфу с страницы подразделения, удаляем выбранное подразделение
    @PostMapping("/actionDepartPage/delete/{id}")
    fun deleteDepartment(@RequestParam("id") id: Long): String {
        departmentServiceImpl.deleteById(id)

        return "redirect:/"
    }
}