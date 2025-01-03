package fi.resthiberapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.resthiberapp.dto.CategoryDTO;
import fi.resthiberapp.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public boolean registerCategory(@RequestBody CategoryDTO dto)
	{
		return categoryService.addNewCategory(dto);
	}
	
	@GetMapping("/getCategory/{cid}")
	public CategoryDTO getCategoryDetails(@PathVariable("cid")int categoryId)
	{
		return categoryService.getCategoryById(categoryId);
	}
	
	@GetMapping("/allCategories")
	public List<CategoryDTO> getAllCategories()
	{
		return categoryService.allCategories();
	}
	
	@GetMapping("/categoriesLike")
	public List<CategoryDTO> categoriesLike(@RequestParam("nameLike")String nameLike)
	{
		return categoryService.getCategoryNameLike(nameLike);
	}
	
	
}











