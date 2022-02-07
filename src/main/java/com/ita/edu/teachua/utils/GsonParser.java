package com.ita.edu.teachua.utils;

import com.google.gson.Gson;

import com.ita.edu.teachua.api.models.about_us.AboutUsRequestModel;
import com.ita.edu.teachua.api.models.banner.BannerModel;
import com.ita.edu.teachua.api.models.center.change_response.Root;
import com.ita.edu.teachua.api.models.challenge.patch.PatchChallenge;
import com.ita.edu.teachua.api.models.challenge.response.AddChallengeResponse;
import com.ita.edu.teachua.api.models.city.city_request.City;
import com.ita.edu.teachua.api.models.category.Category;
import com.ita.edu.teachua.api.models.center.center_request.Center;
import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.api.models.club.add_club_response.District;
import com.ita.edu.teachua.api.models.club.add_club_response.Station;
import com.ita.edu.teachua.api.models.complaint.Complaint;
import com.ita.edu.teachua.api.models.contact.ContactModel;
import com.ita.edu.teachua.api.models.district.DistrictModel;
import com.ita.edu.teachua.api.models.news.NewsModel;
import com.ita.edu.teachua.api.models.roles.RoleNameModel;
import com.ita.edu.teachua.api.models.roles.RoleModel;
import com.ita.edu.teachua.api.models.registration.RegisterUser;
import com.ita.edu.teachua.api.models.station.StationRequestModel;
import com.ita.edu.teachua.api.models.user.SuccessUpdatedUser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {
    private Gson gson;

    private AddClub addClub;
    private AboutUsRequestModel aboutUsRequestModel;
    private StationRequestModel stationRequestModel;
    private ContactModel contactModel;
    private Station stationModel;
    private Complaint complaintModel;
    private Category category;
    private Center center;
    private DistrictModel districtModel;
    private BannerModel bannerModel;
    private RoleModel roleModel;
    private RoleNameModel roleNameModel;
    private NewsModel newsModel;
    private City city;
    private AddChallengeResponse addChallengeResponse;
    private PatchChallenge patchChallenge;
    private RegisterUser registerUser;
    private SuccessUpdatedUser successUpdatedUser;
    private Root centerRoot;

    public GsonParser() {
        gson = new Gson();
    }

    public void parseAddClubJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/club/addClub.json")) {
            this.addClub = gson.fromJson(reader, AddClub.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AddClub getAddClub() {
        return addClub;
    }

    public void parseAddChallengeJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/challenge/addChallenge.json")) {
            this.addChallengeResponse = gson.fromJson(reader, AddChallengeResponse.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AddChallengeResponse getAddChallengeResponse() {
        return addChallengeResponse;
    }

    public void parsePatchChallengeJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/challenge/patchChallenge.json")) {
            this.patchChallenge = gson.fromJson(reader, PatchChallenge.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PatchChallenge getPatchChallenge() {
        return patchChallenge;
    }

    public void parseAddDistrictJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/district/district.json")) {
            this.districtModel = gson.fromJson(reader, DistrictModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DistrictModel getAddDistrict() {
        return districtModel;
    }

    public void parseAddComplaintJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/complaint/add_complaint.json")) {
            this.complaintModel = gson.fromJson(reader, Complaint.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Complaint getComplaint() {
        return complaintModel;
    }

    public void parseAddCenterJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/center/center.json")) {
            this.center = gson.fromJson(reader, Center.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Center getAddCenter() {
        return center;
    }

    public void parseAddNewBannerJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/banner/banner.json")) {
            this.bannerModel = gson.fromJson(reader, BannerModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BannerModel getAddNewBanner() {
        return bannerModel;
    }

    public void parseAddBannerWithWrongPathJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/banner/bannerInvalidData.json")) {
            this.bannerModel = gson.fromJson(reader, BannerModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BannerModel getAddBannerWithWrongPath() {
        return bannerModel;
    }

    public void parseRoleNameJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/roles/roleName.json")) {
            this.roleNameModel = gson.fromJson(reader, RoleNameModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RoleNameModel getRoleNameModel() {
        return roleNameModel;
    }

    public void parseAddNewsJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/news/news.json")) {
            this.newsModel = gson.fromJson(reader, NewsModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public NewsModel getNewsModel() {
        return newsModel;
    }

    public void parseAddNewCityJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/city/city")) {
            this.city = gson.fromJson(reader, City.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AboutUsRequestModel getAboutUsRequestModel() {
        return aboutUsRequestModel;
    }

    public void parseAddAboutUsJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/about_us/about_us.json")) {
            this.aboutUsRequestModel = gson.fromJson(reader, AboutUsRequestModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseChangeAboutUsJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/about_us/change_about_us.json")) {
            this.aboutUsRequestModel = gson.fromJson(reader, AboutUsRequestModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void parseAddContactJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/contact/contact.json")) {
            this.contactModel = gson.fromJson(reader, ContactModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseChangeContactJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/contact/change_contact.json")) {
            this.contactModel = gson.fromJson(reader, ContactModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StationRequestModel getStationRequestModel() {
        return stationRequestModel;
    }

    public void parseAddStationRequestJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/station/station.json")) {
            this.stationRequestModel = gson.fromJson(reader, StationRequestModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public City getAddNewCity() {
        return city;
    }

    public void parseChangeStationJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/station/change_station.json")) {
            this.stationModel = gson.fromJson(reader, Station.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseChangeStationRequestJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/station/change_station.json")) {
            this.stationRequestModel = gson.fromJson(reader, StationRequestModel.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseRegisterUserJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/register/registerUser.json")) {
            this.registerUser = gson.fromJson(reader, RegisterUser.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RegisterUser getRegisterUser() {
        return registerUser;
    }

    public void parseUpdateUserJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/user/updateUser.json")) {
            this.successUpdatedUser = gson.fromJson(reader, SuccessUpdatedUser.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SuccessUpdatedUser getUpdateUser(){
        return successUpdatedUser;
    }

    public Category getAddCategory() {
        return category;
    }

    public void parseAddCategoryJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/category/category.json")) {
            this.category = gson.fromJson(reader, Category.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseCenterRequestJson() {
        try (FileReader reader = new FileReader("src/main/resources/request_bodies/center/center.json")) {
            this.centerRoot = gson.fromJson(reader, Root.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Root getCenterRoot() {
        return centerRoot;
    }

}