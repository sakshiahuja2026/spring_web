package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.ProfileBean;
import com.bean.SecQuestionAnsBean;
import com.bean.UserBean;
import com.dao.ProfileDao;
import com.dao.SecQuestionAnsDao;
import com.service.FileUploadService;


@Controller
public class ProfileController {
	@Autowired
	SecQuestionAnsDao ansDao;
	@Autowired
	ProfileDao profileDao;

	@Autowired
	FileUploadService fileUploadService;


	@GetMapping("/setsecquestion")
	public String setSecQuestionAns(HttpSession session, Model model) {
		UserBean user = (UserBean) session.getAttribute("user");
		List<SecQuestionAnsBean> allQuestions = ansDao.getQuestionByUser(user.getUserId());
		model.addAttribute("allQuestions", allQuestions);
		return "SetSecQuestionAns";
	}

	@PostMapping("/savequestionans")
	public String saveQuestionAns(SecQuestionAnsBean ansBean, HttpSession session, Model model) {

		UserBean user = (UserBean) session.getAttribute("user");
		ansBean.setUserId(user.getUserId());
		ansDao.addQuestion(ansBean);

		model.addAttribute("msg","question added");
		return "Home";
	}
@GetMapping("/newprofile")
	public String newprofile() {
		return "NewProfile";
	}
@PostMapping("/saveprofile")
public String saveProfile(@RequestParam("profile") MultipartFile file,HttpSession session) {
	System.out.println(file.getOriginalFilename());
	System.out.println(file.getSize());
	UserBean user = (UserBean) session.getAttribute("user");
	int userId = user.getUserId();

	try {
	fileUploadService.imageUpload(file, userId);
		ProfileBean profileBean = new ProfileBean();
		profileBean.setUserId(userId);
		profileBean.setImgUrl("resources/images/" + userId + "/" + file.getOriginalFilename());
		profileBean.setActive(true);
		profileDao.addImg(profileBean);

	} catch (Exception e) {
		e.printStackTrace();
	}

	return "NewProfile";
}
@GetMapping("/listprofileimages")
public String getAllImages(HttpSession session, Model model) {
	UserBean user = (UserBean) session.getAttribute("user");
	int userId = user.getUserId();
	List<ProfileBean> profiles = profileDao.getAllProfileImagesByUser(userId);
	model.addAttribute("profiles", profiles);
	return "ListProfileImages";

}
@GetMapping("/deleteprofile")
public String deleteProfile(@RequestParam("profileId") int profileId,Model model) {
	profileDao.deleteProfile(profileId);

	return "redirect:/listprofileimages";//call url 

}

}

