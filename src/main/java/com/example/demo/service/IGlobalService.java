package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Activity;
import com.example.demo.entity.Category;
import com.example.demo.entity.Club;
import com.example.demo.entity.Competition;
import com.example.demo.entity.Event;
import com.example.demo.entity.Image;
import com.example.demo.entity.Licence;
import com.example.demo.entity.Localisation;
import com.example.demo.entity.Message;
import com.example.demo.entity.Result;
import com.example.demo.entity.Role;
import com.example.demo.entity.Team;
import com.example.demo.entity.Training;
import com.example.demo.entity.User;

public interface IGlobalService {
	// Les méthodes en commentaire ne sont pas encore utiles car certaines données
	// seront rentrées en dures dans la bdd pour la V1
	
	// La méthode add permet aussi un update d'une instance
	
	
	// Club
	public List<Club> getClubs();
	
//	public Club addClub(Club newClub);
	
//	public void deleteClub(int id);
	
	public Club getClubById(int id);
	
	// Event
	public List<Event> getEvents();
	
//	public Event addEvent(Event newEvent);
	
//	public void deleteEvent(int id);
	
//	public Event getEventById(int id);
	
	// Authentification
	// public login
	
	// User
	public List<User> getUsers();
	
	public User addUser(User newUser);
	
	public void deleteUser(int id);
	
	public User getUserById(int id);
	
	// Role
	public List<Role> getRoles();
	
//	public Role addRole(Role newRole);
	
//	public void deleteRole(int id);
	
	public Role getRoleById(int id);
	
	// Message
	public List<Message> getMessages();
	
	public Message addMessage(Message newMessage);
	
	public void deleteMessage(int id);
	
	public Message getMessageById(int id);
	
	// Image
//	public List<Image> getImages();
	
	public Image addImage(Image newImage);
	
	public void deleteImage(int id);
	
	public Image getImageByUserId(int userId);
	
	// Licence
	public List<Licence> getLicences();
	
//	public Licence addLicence(Licence newLicence);
	
//	public void deleteLicence(int id);
	
	public Licence getLicenceById(int id);
	
	// Activity
	public List<Activity> findAll();
	
//	public Activity addActivity(Activity newActivity);
	
//	public void deleteActivity(int id);
	
	public Activity findById(int id);
	
	// Team
	public List<Team> getTeams();
	
	public Team addTeam(Team newTeam);
	
	public void deleteTeam(int id);
	
	public Team getTeamById(int id);
	
	// Category
	public List<Category> getCategories();
	
//	public Category addCategory(Category newCategory);
	
//	public void deleteCategory(int id);
	
	public Category getCategoryById(int id);
	
	// Training
	public List<Training> getTrainings();
	
//	public Training addTraining(Training newTraining);
	
//	public void deleteTraining(int id);
	
	public Training getTrainingById(int id);
	
	// Competition
	public List<Competition> getCompetitions();
	
//	public Competition addCompetition(Competition newCompetition);
	
//	public void deleteCompetition(int id);
	
	public Competition getCompetitionById(int id);
	
	// Result
	public List<Result> getResults();
	
	public Result addResult(Result newResult);
	
//	public void deleteResult(int id);
	
	public Result getResultById(int id);
	
	// Localisation
//	public List<Localisation> getLocalisations();
	
	public Localisation addLocalisation(Localisation newLocalisation);
	
	public void deleteLocalisation(int id);
	
	public Localisation getLocalisationById(int id);

}
