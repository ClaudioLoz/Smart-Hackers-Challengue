# # import sys
# # import os
# #
# # workingdirectory = os.getcwd()
# #
# # def Addition():
# #     num1 = sys.argv[1]
# #     num2 = sys.argv[2]
# #     suma = int(num1) + int(num2)
# #     print("La suma de {0} y {1} es {2} ", num1,num2,suma)
# #
# # Addition()
# from selenium import webdriver
# from bs4 import BeautifulSoup
# import time
# import re
# from selenium.webdriver.chrome.options import Options  # for suppressing the browser
#
# option = webdriver.ChromeOptions()
# option.add_argument('headless')
#
# list = []
#
# url = "https://www.linkedin.com/in/ivan-cordova/"
#
#
#
# # Creating an instance
# driver = webdriver.Chrome(executable_path=r"D:\2022\chromedriver.exe",options=option)
#
# # Logging into LinkedIn
# driver.get("https://linkedin.com/uas/login")
# time.sleep(5)
#
# username = driver.find_element_by_id("username")
# username.send_keys("droidmaniaco25@gmail.com") # Enter Your Email Address
#
# pword = driver.find_element_by_id("password")
# pword.send_keys("prueba123")	 # Enter Your Password
#
# driver.find_element_by_xpath("//button[@type='submit']").click()
#
#
# driver.get(url)	 # this will open the link
#
# start = time.time()
#
# # will be used in the while loop
# initialScroll = 0
# finalScroll = 1000
#
# while True:
# 	driver.execute_script(f"window.scrollTo({initialScroll},{finalScroll})")
# 	# this command scrolls the window starting from
# 	# the pixel value stored in the initialScroll
# 	# variable to the pixel value stored at the
# 	# finalScroll variable
# 	initialScroll = finalScroll
# 	finalScroll += 1000
#
# 	# we will stop the script for 3 seconds so that
# 	# the data can load
# 	time.sleep(3)
# 	# You can change it as per your needs and internet speed
#
# 	end = time.time()
#
# 	# We will scroll for 20 seconds.
# 	# You can change it as per your needs and internet speed
# 	if round(end - start) > 20:
# 		break
#
# src = driver.page_source
#
# # Now using beautiful soup
# soup = BeautifulSoup(src, 'lxml')
#
# # Extracting the HTML of the complete introduction box
# # that contains the name, company name, and the location
# intro = soup.find('div', {'class': 'pv-text-details__left-panel'})
#
# #print(intro)
#
# # In case of an error, try changing the tags used here.
#
# name_loc = intro.find("h1")
#
# # Extracting the Name
# name = name_loc.get_text().strip()
# # strip() is used to remove any extra blank spaces
#
# works_at_loc = intro.find("div", {'class': 'text-body-medium'})
#
# # this gives us the HTML of the tag in which the Company Name is present
# # Extracting the Company Name
# works_at = works_at_loc.get_text().strip()
#
#
# location_loc = intro.find_all("span", {'class': 'text-body-small'})
#
# # Ectracting the Location
# # The 2nd element in the location_loc variable has the location
# lName = []
# lName.append("Name")
# lName.append(name)
# list.append(lName)
# lWork = []
# lWork.append("Works")
# lWork.append(works_at)
# list.append(lWork)
#
#
#
# # Getting the HTML of the Experience section in the profile
# experience = soup.find("section", {"id": "experience-section"}).find('ul')
#
# #print(experience)
#
# # In case of an error, try changing the tags used here.
#
# li_tags = experience.find('div')
# a_tags = li_tags.find("a")
# job_title = a_tags.find("h3").get_text().strip()
#
# lJob = []
# lJob.append("Job title")
# lJob.append(job_title)
# list.append(lJob)
#
# company_name_html = soup.find_all(
# 'p', {'class': 'pv-entity__secondary-title t-14 t-black t-normal'})
# company_names = []
#
# for name in company_name_html:
#     v = " ".join(name.text.strip().split())
#     company_names.append(v)
#
#
# experience_html = soup.find_all(
# 'h3', {'class': 't-16 t-black t-bold'})
# experience_names = []
#
# for name in experience_html:
#     v = " ".join(name.text.strip().split())
#     experience_names.append(v)
#
# list.append("Company work name")
# list.append(company_names)
# list.append("Experience")
# list.append(experience_names)
#
# print(list)
#

class carro:
    def __init__(self,placa,dueno,utensilios):
        self.placa = placa
        self.dueno = dueno
        self.utensilios = utensilios

    def toString(self):
        return str(self.placa) + "," + self.dueno + "," + str(self.utensilios)


placa = 190238
dueno = "oscar"
utensilios = ["akds","asdasdasd","01293jkasldjkl"]

carro = carro(placa,dueno,utensilios)
print(carro.toString())
