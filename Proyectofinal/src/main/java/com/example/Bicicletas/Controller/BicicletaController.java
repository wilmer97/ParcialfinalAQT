package com.example.Bicicletas.Controller;


import com.example.Bicicletas.InterfaceService.IBicicletaService;
import com.example.Bicicletas.Model.Bicicleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Bicicleta")
public class BicicletaController {

    @Autowired
    private IBicicletaService service;

    @GetMapping("/listar")
    public String listarBicicleta(Model model){
        model.addAttribute("titulo", "bicicletas");
        model.addAttribute("bicicletas", "Lista de bicicletas");
        return "index";
    }

    @GetMapping("/nuevo")
    public String formAgregarBicicleta(Model model) {
        model.addAttribute("titulo", "Nuevo registro");
        model.addAttribute("bicicleta", new Bicicleta());
        return "bicicletas/nuevo"; // Asegúrate de que esta vista exista
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Bicicleta bicicleta){
        service.guardar(bicicleta);
        return "redirect:/bicicletas/listar";
    }

    @GetMapping("/edirtar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        Bicicleta bicicleta = service.obtenerPorId(id).orElse(null);
        if (bicicleta != null){
            model.addAttribute("bicicleta", bicicleta);
            return "bicicletas/editar";
        }else {
            return "redirect:/bicicletas/listar";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id){
        service.eliminar(id);
        return "redirect:/bicicletas/listar";
    }

    @GetMapping("/")
    public String index(Model model) {
        return "bicicleta/index";
    }
}
