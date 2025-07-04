package com.codegym.ung_dung_blog.controller;

import com.codegym.ung_dung_blog.model.Blog;
import com.codegym.ung_dung_blog.model.Category;
import com.codegym.ung_dung_blog.service.IBlogService;
import com.codegym.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String listBlogs(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page, 5));
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("currentPage", page);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return "error/404";
        }
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return "error/404";
        }
        model.addAttribute("blog", blog);
        return "blog/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Blog> blogs = blogService.searchByTitle(keyword);
        model.addAttribute("blogs", blogs); // ✅ đổi tên biến để view dễ phân biệt
        return "blog/_table :: tableFragment";
    }

    @GetMapping("/load")
    public String loadMore(@RequestParam int page, Model model) {
        Page<Blog> blogPage = blogService.findAll(PageRequest.of(page, 5));
        model.addAttribute("blogPage", blogPage); // ✅ giữ nguyên dạng Page
        model.addAttribute("currentPage", page);
        return "blog/_table :: tableFragment";
    }

    @GetMapping("/category/{id}")
    public String viewByCategory(@PathVariable Long id, Model model) {
        List<Blog> blogs = blogService.findByCategoryId(id);
        model.addAttribute("blogs", blogs); // ✅ đặt đúng tên, vì đây là List
        model.addAttribute("selectedCategory", id);
        return "blog/list";
    }
}
