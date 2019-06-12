(ns app.db
  (:require [re-frame.core :as rf]))

(def luke
  {:id 1
   :image      "luke.jpg"
   :mass       "77",
   :birth_year "19BBY",
   :skin_color "fair",
   :name       "Luke Skywalker",
   :species    ["https://swapi.co/api/species/1/"],
   :films
   ["https://swapi.co/api/films/2/"
    "https://swapi.co/api/films/6/"
    "https://swapi.co/api/films/3/"
    "https://swapi.co/api/films/1/"
    "https://swapi.co/api/films/7/"],
   :url        "https://swapi.co/api/people/1/",
   :hair_color "blond",
   :gender     "male",
   :eye_color  "blue",
   :homeworld  "https://swapi.co/api/planets/1/",
   :height     "172"})


(def c3p0
  {:id 2
   :image      "c3p0.jpg"
   :mass       "75",
   :birth_year "112BBY",
   :skin_color "gold",
   :name       "C-3PO",
   :species    ["https://swapi.co/api/species/2/"],
   :films
   ["https://swapi.co/api/films/2/"
    "https://swapi.co/api/films/5/"
    "https://swapi.co/api/films/4/"
    "https://swapi.co/api/films/6/"
    "https://swapi.co/api/films/3/"
    "https://swapi.co/api/films/1/"],
   :url        "https://swapi.co/api/people/2/",
   :hair_color "n/a",
   :gender     "n/a",
   :eye_color  "yellow",
   :homeworld  "https://swapi.co/api/planets/1/",
   :height     "167"})


(def r2d2
  {:id         3
   :image      "r2d2.jpg"
   :mass       "32",
   :birth_year "33BBY",
   :skin_color "white, blue",
   :name       "R2-D2",
   :species    ["https://swapi.co/api/species/2/"],
   :films
   ["https://swapi.co/api/films/2/"
    "https://swapi.co/api/films/5/"
    "https://swapi.co/api/films/4/"
    "https://swapi.co/api/films/6/"
    "https://swapi.co/api/films/3/"
    "https://swapi.co/api/films/1/"
    "https://swapi.co/api/films/7/"],
   :url        "https://swapi.co/api/people/3/",
   :hair_color "n/a",
   :gender     "n/a",
   :eye_color  "red",
   :homeworld  "https://swapi.co/api/planets/8/",
   :height     "96"})


(def vader
  {:id         4
   :image      "darth-vader.jpg"
   :mass       "136",
   :birth_year "41.9BBY",
   :skin_color "white",
   :name       "Darth Vader",
   :species    ["https://swapi.co/api/species/1/"],
   :films
   ["https://swapi.co/api/films/2/"
    "https://swapi.co/api/films/6/"
    "https://swapi.co/api/films/3/"
    "https://swapi.co/api/films/1/"],
   :url        "https://swapi.co/api/people/4/",
   :hair_color "none",
   :gender     "male",
   :eye_color  "yellow",
   :homeworld  "https://swapi.co/api/planets/1/",
   :height     "202"})


(def leia
  {:id         5
   :image      "leia.jpg"
   :mass       "49",
   :birth_year "19BBY",
   :skin_color "light",
   :name       "Leia Organa",
   :species    ["https://swapi.co/api/species/1/"],
   :films
   ["https://swapi.co/api/films/2/"
    "https://swapi.co/api/films/6/"
    "https://swapi.co/api/films/3/"
    "https://swapi.co/api/films/1/"
    "https://swapi.co/api/films/7/"],
   :url        "https://swapi.co/api/people/5/",
   :hair_color "brown",
   :gender     "female",
   :eye_color  "brown",
   :homeworld  "https://swapi.co/api/planets/2/",
   :height     "150"})


(def yoda
  {:id         20
   :image      "yoda.png"
   :mass       "17",
   :birth_year "896BBY",
   :skin_color "green",
   :name       "Yoda",
   :species    ["https://swapi.co/api/species/6/"],
   :films
   ["https://swapi.co/api/films/2/"
    "https://swapi.co/api/films/5/"
    "https://swapi.co/api/films/4/"
    "https://swapi.co/api/films/6/"
    "https://swapi.co/api/films/3/"],
   :url        "https://swapi.co/api/people/20/",
   :hair_color "white",
   :gender     "male",
   :eye_color  "brown",
   :homeworld  "https://swapi.co/api/planets/28/",
   :height     "66"})


(def initial-app-db {:quotes  {5  "\"Help me, Obi-Wan Kenobi. You’re my only hope.\""
                               20 "\"Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering.\""
                               4  "\"I am altering the deal, pray I don't alter it any further.\""
                               1  "\"I’m Luke Skywalker. I’m here to rescue you.\""
                               2  "\"Sir, the possibility of successfully navigating an asteroid field is approximately three thousand seven hundred and twenty to one!\""
                               3  "\"Beep Bloop Blop Bleep Boop\""}
                     :people  {1  luke
                               2  c3p0
                               3  r2d2
                               4  vader
                               5  leia
                               20 yoda}
                     :films   {1 {:release_date "1977-05-25",
                                  :director     "George Lucas",
                                  :opening_crawl
                                  "It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....",
                                  :title        "A New Hope",
                                  :url          "https://swapi.co/api/films/1/",
                                  :episode_id   4}
                               2 {:release_date  "1980-05-17",
                                  :director      "Irvin Kershner",
                                  :opening_crawl "It is a dark time for the\r\nRebellion. Although the Death\r\nStar has been destroyed,\r\nImperial troops have driven the\r\nRebel forces from their hidden\r\nbase and pursued them across\r\nthe galaxy.\r\n\r\nEvading the dreaded Imperial\r\nStarfleet, a group of freedom\r\nfighters led by Luke Skywalker\r\nhas established a new secret\r\nbase on the remote ice world\r\nof Hoth.\r\n\r\nThe evil lord Darth Vader,\r\nobsessed with finding young\r\nSkywalker, has dispatched\r\nthousands of remote probes into\r\nthe far reaches of space....",
                                  :title         "The Empire Strikes Back",
                                  :url           "https://swapi.co/api/films/2/",
                                  :episode_id    5}
                               3 {:release_date "1983-05-25",
                                  :director     "Richard Marquand",
                                  :opening_crawl
                                  "Luke Skywalker has returned to\r\nhis home planet of Tatooine in\r\nan attempt to rescue his\r\nfriend Han Solo from the\r\nclutches of the vile gangster\r\nJabba the Hutt.\r\n\r\nLittle does Luke know that the\r\nGALACTIC EMPIRE has secretly\r\nbegun construction on a new\r\narmored space station even\r\nmore powerful than the first\r\ndreaded Death Star.\r\n\r\nWhen completed, this ultimate\r\nweapon will spell certain doom\r\nfor the small band of rebels\r\nstruggling to restore freedom\r\nto the galaxy...",
                                  :title        "Return of the Jedi",
                                  :url          "https://swapi.co/api/films/3/",
                                  :episode_id   6}
                               7 {:release_date "2015-12-11",
                                  :director     "J. J. Abrams",
                                  :opening_crawl
                                  "Luke Skywalker has vanished.\r\nIn his absence, the sinister\r\nFIRST ORDER has risen from\r\nthe ashes of the Empire\r\nand will not rest until\r\nSkywalker, the last Jedi,\r\nhas been destroyed.\r\n \r\nWith the support of the\r\nREPUBLIC, General Leia Organa\r\nleads a brave RESISTANCE.\r\nShe is desperate to find her\r\nbrother Luke and gain his\r\nhelp in restoring peace and\r\njustice to the galaxy.\r\n \r\nLeia has sent her most daring\r\npilot on a secret mission\r\nto Jakku, where an old ally\r\nhas discovered a clue to\r\nLuke's whereabouts....",
                                  :title        "The Force Awakens",
                                  :url          "https://swapi.co/api/films/7/",
                                  :episode_id   7}}
                     :planets {1 {:surface_water   "1",
                                  :climate         "arid",
                                  :residents
                                  ["https://swapi.co/api/people/1/"
                                   "https://swapi.co/api/people/2/"
                                   "https://swapi.co/api/people/4/"
                                   "https://swapi.co/api/people/6/"
                                   "https://swapi.co/api/people/7/"
                                   "https://swapi.co/api/people/8/"
                                   "https://swapi.co/api/people/9/"
                                   "https://swapi.co/api/people/11/"
                                   "https://swapi.co/api/people/43/"
                                   "https://swapi.co/api/people/62/"],
                                  :orbital_period  "304",
                                  :name            "Tatooine",
                                  :diameter        "10465",
                                  :created         "2014-12-09T13:50:49.641000Z",
                                  :gravity         "1 standard",
                                  :edited          "2014-12-21T20:48:04.175778Z",
                                  :films
                                  ["https://swapi.co/api/films/5/"
                                   "https://swapi.co/api/films/4/"
                                   "https://swapi.co/api/films/6/"
                                   "https://swapi.co/api/films/3/"
                                   "https://swapi.co/api/films/1/"],
                                  :population      "200000",
                                  :terrain         "desert",
                                  :url             "https://swapi.co/api/planets/1/",
                                  :rotation_period "23"}

                               8 {:surface_water   "12",
                                  :climate         "temperate",
                                  :residents
                                  ["https://swapi.co/api/people/3/"
                                   "https://swapi.co/api/people/21/"
                                   "https://swapi.co/api/people/36/"
                                   "https://swapi.co/api/people/37/"
                                   "https://swapi.co/api/people/38/"
                                   "https://swapi.co/api/people/39/"
                                   "https://swapi.co/api/people/42/"
                                   "https://swapi.co/api/people/60/"
                                   "https://swapi.co/api/people/61/"
                                   "https://swapi.co/api/people/66/"
                                   "https://swapi.co/api/people/35/"],
                                  :orbital_period  "312",
                                  :name            "Naboo",
                                  :diameter        "12120",
                                  :created         "2014-12-10T11:52:31.066000Z",
                                  :gravity         "1 standard",
                                  :edited          "2014-12-20T20:58:18.430000Z",
                                  :films
                                  ["https://swapi.co/api/films/5/"
                                   "https://swapi.co/api/films/4/"
                                   "https://swapi.co/api/films/6/"
                                   "https://swapi.co/api/films/3/"],
                                  :population      "4500000000",
                                  :terrain         "grassy hills, swamps, forests, mountains",
                                  :url             "https://swapi.co/api/planets/8/",
                                  :rotation_period "26"}

                               2 {:surface_water   "40",
                                  :climate         "temperate",
                                  :residents
                                  ["https://swapi.co/api/people/5/"
                                   "https://swapi.co/api/people/68/"
                                   "https://swapi.co/api/people/81/"],
                                  :orbital_period  "364",
                                  :name            "Alderaan",
                                  :diameter        "12500",
                                  :created         "2014-12-10T11:35:48.479000Z",
                                  :gravity         "1 standard",
                                  :edited          "2014-12-20T20:58:18.420000Z",
                                  :films
                                  ["https://swapi.co/api/films/6/" "https://swapi.co/api/films/1/"],
                                  :population      "2000000000",
                                  :terrain         "grasslands, mountains",
                                  :url             "https://swapi.co/api/planets/2/",
                                  :rotation_period "24"}

                               28 {:surface_water   "unknown",
                                   :climate         "unknown",
                                   :residents
                                   ["https://swapi.co/api/people/20/"
                                    "https://swapi.co/api/people/23/"
                                    "https://swapi.co/api/people/29/"
                                    "https://swapi.co/api/people/32/"
                                    "https://swapi.co/api/people/75/"
                                    "https://swapi.co/api/people/84/"
                                    "https://swapi.co/api/people/85/"
                                    "https://swapi.co/api/people/86/"
                                    "https://swapi.co/api/people/87/"
                                    "https://swapi.co/api/people/88/"],
                                   :orbital_period  "0",
                                   :name            "unknown",
                                   :diameter        "0",
                                   :created         "2014-12-15T12:25:59.569000Z",
                                   :gravity         "unknown",
                                   :edited          "2014-12-20T20:58:18.466000Z",
                                   :films           [],
                                   :population      "unknown",
                                   :terrain         "unknown",
                                   :url             "https://swapi.co/api/planets/28/",
                                   :rotation_period "0"}}})


(rf/reg-event-db
  :initialize-db
  (fn [_ _] initial-app-db))
