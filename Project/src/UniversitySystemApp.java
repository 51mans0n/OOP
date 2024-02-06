import java.util.Scanner;
import java.io.IOException;
import java.io.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;


import java.util.ArrayList;

public class UniversitySystemApp {
    private static UniversityDataStore dataStore;
    private static final String DATA_STORE_PATH = "universityData.ser";
    private static User currentUser;

    public static void main(String[] args) {
        dataStore = loadUniversityData();

//        Admin olegAdmin = new Admin("Oleg", "ol_pr@kbtu.kz", "adminpass", "ID1001", DepartmentType.ADMINISTRATION, dataStore, Language.EN);
//        dataStore.addUser(olegAdmin);

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            if (currentUser == null) {
                System.out.println("Please enter your email and password.");
                String email = scanner.nextLine();
                String password = scanner.nextLine();
                currentUser = authenticateUser(email, password);

                if (currentUser == null) {
                    System.out.println("Login failed. Please try again.");
                }
            }

            if (currentUser != null) {
                displayUserInterface(scanner);
            }

            System.out.println("1: Switch User");
            System.out.println("9: Exit Application");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (choice) {
                case 1: // Выход из аккаунта и переход к новой аутентификации
                    if (currentUser != null) {
                        currentUser.logout();
                        printLocalizedText("You have successfully logged out.",
                                "Вы успешно вышли из системы.",
                                "Сіз жүйеден сәтті шықтыңыз.");
                        currentUser = null;
                    }
                    break;
                case 9: // Полный выход из приложения
                    saveUniversityData(dataStore);
                    isRunning = false;
                    break;
                default:
                    printLocalizedText("Wrong choice. Please try again.",
                            "Неправильный выбор. Пожалуйста, попробуйте еще раз.",
                            "Қате таңдау. Қайталап көріңіз.");
            }
        }

        saveUniversityData(dataStore);
        scanner.close();
    }
    private static void displayUserInterface(Scanner scanner) {
        if (currentUser instanceof GraduateStudent) {
            displayGraduateStudentMenu(scanner);
        }
        else if (currentUser instanceof Admin) {
            displayAdminMenu(scanner);
        }
        else if (currentUser instanceof Student) {
            displayStudentMenu(scanner);
        }
        else if (currentUser instanceof Teacher) {
            displayTeacherMenu(scanner);
        }
    }
    private static User authenticateUser(String email, String password) {
        for (User user : dataStore.getUsers()) {
            if (user.getEmail().equalsIgnoreCase(email) && user.login(password)) {
                return user;
            }
        }
        return null;
    }

    private static void displayStudentMenu(Scanner scanner) {
        boolean studentMenuActive = true;
        while (studentMenuActive) {
            saveUniversityData(dataStore);
            printLocalizedText("Student Menu:",
                    "Студенческое меню:",
                    "Студенттік мәзір:");
            printLocalizedText("1. View Available Courses",
                    "1. Просмотр доступных курсов",
                    "1. Қолжетімді курстарды қараңыз");
            printLocalizedText("2. View My Courses",
                    "2. Просмотр моих курсов",
                    "2. Менің курстарымды көру");
            printLocalizedText("3. Apply for a Course",
                    "3. Подать заявку на курс",
                    "3. Курсқа өтініш беріңіз");
            printLocalizedText("4. View My Transcript",
                    "4. Просмотр моей стенограммы",
                    "4. Менің транскриптімді қарау");
            printLocalizedText("5. View My Grades",
                    "5. Просмотр моих оценок",
                    "5. Менің бағаларымды көру");
            printLocalizedText("6. Engage in research activities",
                    "6. Engage in research activities",
                    "6. Ғылыми-зерттеу қызметімен айналысу");
            printLocalizedText("7. Change Language",
                    "7. Изменить язык",
                    "7. Тілді өзгерту");
            printLocalizedText("8. Logout",
                    "8. Выход из системы",
                    "8. Шығу");
            printLocalizedText("Please choose an option:",
                    "Пожалуйста, выберите опцию:",
                    "Опцияны таңдаңыз:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (choice) {
                case 1:
                    viewAvailableCourses();
                    break;
                case 2:
                    // Логика для просмотра курсов, на которые студент записан
                    break;
                case 3:
                    applyForCourse(scanner);
                    break;
                case 4:
                    // Логика для просмотра транскрипта студента
                    break;
                case 5:
                    // Логика для просмотра оценок студента
                    break;
                case 6:
                    displayResearchMenu(scanner);
                    break;
                case 7:
                    printLocalizedText("Choose language: 1. English, 2. Russian, 3. Kazakh",
                            "Выберите язык: 1. Английский, 2. Русский, 3. Казахский.",
                            "Тілді таңдаңыз: 1. Ағылшын, 2. Орыс, 3. Қазақ");
                    int langChoice = scanner.nextInt();
                    Language selectedLanguage = Language.values()[langChoice - 1];
                    currentUser.changeLanguage(selectedLanguage);
                    printLocalizedText("Language changed to: " + selectedLanguage,
                            "Язык изменен на: " + selectedLanguage,
                            "Тіл өзгертілді: " + selectedLanguage);
                    saveUniversityData(dataStore);
                    break;
                case 8:
                    studentMenuActive = false;
                    break;
                default:
                    printLocalizedText("Invalid choice. Please try again.",
                            "Неверный выбор. Пожалуйста, попробуйте еще раз.",
                            "Жарамсыз таңдау. Қайталап көріңіз.");
            }
        }
    }
    private static void displayGraduateStudentMenu(Scanner scanner) {
        boolean graduateMenuActive = true;
        while (graduateMenuActive) {
            printLocalizedText("Graduate Student Menu:",
                    "Меню аспиранта:",
                    "Магистранттар мәзірі:");
            printLocalizedText("1. View Available Courses",
                    "1. Просмотр доступных курсов",
                    "1. Қолжетімді курстарды қараңыз");
            printLocalizedText("2. View My Courses",
                    "2. Просмотр моих курсов",
                    "2. Менің курстарымды көру");
            printLocalizedText("3. Apply for a Course",
                    "3. Подайте заявку на курс",
                    "3. Курсқа өтініш беріңіз");
            printLocalizedText("4. View Research Projects",
                    "4. Просмотр исследовательских проектов",
                    "4. Зерттеу жобаларын қарау");
            printLocalizedText("5. Participate in Research Project",
                    "5. Примите участие в исследовательском проекте.",
                    "5. Зерттеу жобасына қатысу");
            printLocalizedText("6. Publish Research Paper",
                    "6. Опубликовать исследовательскую работу",
                    "6. Зерттеу жұмысын жариялау");
            printLocalizedText("7. View My Research Activities",
                    "7. Просмотр моей исследовательской деятельности",
                    "7. Менің зерттеу әрекеттерімді қарау");
            printLocalizedText("8. Create a Research project",
                    "8. Создайте исследовательский проект",
                    "8. Зерттеу жобасын жасаңыз");
            printLocalizedText("9. Research journal",
                    "9. Научный журнал",
                    "9. Зерттеу журналы");
            printLocalizedText("10. Change Language",
                    "10. Изменить язык",
                    "10. Тілді өзгерту");
            printLocalizedText("11. Logout",
                    "11. Выход из системы",
                    "11. Шығу");
            printLocalizedText("Please choose an option:",
                    "Пожалуйста, выберите опцию:",
                    "Опцияны таңдаңыз:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (choice) {
                case 1:
                    viewAvailableCourses();
                    break;
                case 2:
                    // Логика для просмотра курсов, на которые аспирант записан
                    break;
                case 3:
                    applyForCourse(scanner);
                    break;
                case 4:
                    List<ResearchProject> projects = dataStore.getResearchProjects();
                    if (projects.isEmpty()) {
                        printLocalizedText("There are no research projects available at this time.",
                                "На данный момент нет доступных исследовательских проектов.",
                                "Қазіргі уақытта ғылыми жобалар жоқ.");
                    }
                    else {
                        printLocalizedText("Available research projects:",
                                "Доступные исследовательские проекты:",
                                "Қолжетімді ғылыми жобалар:");
                        for (ResearchProject project : projects) {
                            System.out.println("ID: " + project.getProjectId());
                            printLocalizedText("Name: " + project.getTitle(), "Название: " + project.getTitle(), "Аты: " + project.getTitle());
                            printLocalizedText("Theme: " + project.getTheme(), "Тема: " + project.getTheme(), "Тақырып: " + project.getTheme());
                        }
                    }
                    saveUniversityData(dataStore);
                    break;
                case 5:
                    printLocalizedText("Enter the name of the research project to participate:",
                            "Введите название исследовательского проекта для участия:",
                            "Қатысу үшін ғылыми жобаның атын енгізіңіз:");
                    String projectName = scanner.nextLine();
                    ResearchProject projectToJoin = dataStore.getProjectByTitle(projectName);

                    if (projectToJoin != null) {
                        if (currentUser instanceof Researcher) {
                            Researcher researcher = (Researcher) currentUser;
                            // Проверка, участвует ли пользователь уже в проекте
                            if (!researcher.getResearchProjects().contains(projectToJoin)) {
                                researcher.participateInProject(projectToJoin);
                                if (researcher instanceof User) {
                                    User userParticipant = (User) researcher;
                                    printLocalizedText("A new member has been added to the project:" + userParticipant.getName(),
                                            "Добавлен новый участник в проект: " + userParticipant.getName(),
                                            "Жобаға жаңа мүше қосылды:" + userParticipant.getName());
                                }
                                printLocalizedText("You have successfully joined the project: " + projectName,
                                        "Вы успешно присоединились к проекту: " + projectName,
                                        "Сіз жобаға сәтті қосылдыңыз: " + projectName);
                            }
                            else {
                                printLocalizedText("You are already a participant in this project.",
                                        "Вы уже участник данного проекта.",
                                        "Сіз бұл жобаның қатысушысысыз.");
                            }
                        }
                        else {
                            printLocalizedText("Your current role does not allow you to participate in projects.",
                                    "Ваша текущая роль не позволяет участвовать в проектах.",
                                    "Сіздің қазіргі рөліңіз жобаларға қатысуға мүмкіндік бермейді.");
                        }
                    }
                    else {
                        printLocalizedText("Project not found.",
                                "Проект не найден.",
                                "Жоба табылмады.");
                    }
                    saveUniversityData(dataStore);
                    break;
                case 6:
                    printLocalizedText("Enter the project ID for your research paper:",
                            "Введите идентификатор проекта для вашей исследовательской работы:",
                            "Зерттеу жұмысыңыз үшін жоба идентификаторын енгізіңіз:");
                    String projectIdTemp = scanner.nextLine();
                    ResearchProject selectedProject = dataStore.getProjectById(projectIdTemp);

                    if (selectedProject != null) {
                        if (currentUser instanceof Researcher && ((Researcher) currentUser).getResearchProjects().contains(selectedProject)) {
                            printLocalizedText("Enter information about the scientific work: Title, abstract, number of pages, DOI, publication date (yyyy-mm-dd)",
                                    "Введите информацию о научной работе: Название, аннотацию, количество страниц, DOI, дату публикации (гггг-мм-дд)",
                                    "Ғылыми жұмыс туралы ақпаратты енгізіңіз: Тақырып, реферат, беттер саны, DOI, жарияланған күні (жжжж-мм-кк)");
                            String paperId = UUID.randomUUID().toString();
                            String title = scanner.nextLine();
                            String abstractText = scanner.nextLine();
                            int pageCount = scanner.nextInt();
                            scanner.nextLine(); // Очистка буфера
                            String doi = scanner.nextLine();
                            String dateStr = scanner.nextLine();

                            // Конвертация строки в Date
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            Date publishedDate;
                            try {
                                publishedDate = formatter.parse(dateStr);
                            }
                            catch (ParseException e) {
                                printLocalizedText("Invalid date format.",
                                        "Неверный формат даты.",
                                        "Күн пішімі жарамсыз.");
                                break;
                            }

                            // Создание списка авторов
                            List<String> authors = new ArrayList<>();
                            printLocalizedText("Enter the number of authors:",
                                    "Введите количество авторов:",
                                    "Авторлар санын енгізіңіз:");
                            int authorsCount = scanner.nextInt();
                            scanner.nextLine(); // Очистка буфера
                            for (int i = 0; i < authorsCount; i++) {
                                System.out.println("Введите имя автора " + (i + 1) + ":");
                                authors.add(scanner.nextLine());
                            }

                            ResearchPaper paper = new ResearchPaper(paperId, title, authors, abstractText, pageCount, doi, publishedDate);
                            if (currentUser instanceof Researcher) {
                                Researcher researcher = (Researcher) currentUser;
                                researcher.addPublishedPaper(paper); // Добавляем работу в список опубликованных работ исследователя
                                selectedProject.addPaper(paper); // Добавляем работу в проект
                                dataStore.updateResearchProject(selectedProject); // Обновление проекта с новой работой
                                saveUniversityData(dataStore);
                                printLocalizedText("Scientific work has been added to the project.",
                                        "Научная работа добавлена в проект.",
                                        "Жобаға ғылыми жұмыстар қосылды.");
                            }
                            else {
                                printLocalizedText("Only researchers can publish work.",
                                        "Только исследователи могут публиковать работы.",
                                        "Жұмысты тек зерттеушілер ғана жариялай алады.");
                            }
                        }
                        else {
                            printLocalizedText("You cannot publish work on a project in which you are not involved.",
                                    "Вы не можете публиковать работы в проекте, в котором не участвуете.",
                                    "Сіз қатыспаған жобадағы жұмысты жариялай алмайсыз.");
                        }
                    }
                    else {
                        printLocalizedText("Project not found.",
                                "Проект не найден.",
                                "Жоба табылмады.");
                    }
                    saveUniversityData(dataStore);
                    break;

                case 7:
                    if (currentUser instanceof Researcher) {
                        Researcher researcher = (Researcher) currentUser;
                        printLocalizedText("Published works:",
                                "Опубликованные работы:",
                                "Жарияланған жұмыстар:");
                        for (ResearchPaper paper : researcher.getPublishedPapers()) {
                            System.out.println(paper.getTitle() + " - " + paper.getPublishedDate());
                        }
                        printLocalizedText("Research projects:",
                                "Исследовательские проекты:",
                                "Ғылыми жобалар:");
                        for (ResearchProject projectTemp : researcher.getResearchProjects()) {
                            System.out.println(projectTemp.getTitle() + " - " + projectTemp.getTheme());
                        }
                    }
                    else {
                        printLocalizedText("Only researchers have research activities.",
                                "Только исследователи имеют исследовательскую деятельность.",
                                "Тек зерттеушілер ғана ғылыми-зерттеу қызметімен айналысады.");
                    }
                    saveUniversityData(dataStore);
                    break;
                case 8:
                    printLocalizedText("Enter the name of the research project:",
                            "Введите название исследовательского проекта:",
                            "Зерттеу жобасының атын енгізіңіз:");
                    String projectNameTemp = scanner.nextLine();
                    printLocalizedText("Enter your research topic:",
                            "Введите тему исследования:",
                            "Зерттеу тақырыбыңызды енгізіңіз:");
                    String researchTheme = scanner.nextLine();

                    // Генерация уникального ID для проекта
                    String projectIdGen = UUID.randomUUID().toString();

                    // Создание нового исследовательского проекта
                    ResearchProject newProject = new ResearchProject(projectIdGen, projectNameTemp, researchTheme);

                    // Добавление текущего пользователя как участника проекта, если он может быть исследователем
                    if (currentUser instanceof Researcher) {
                        Researcher researcher = (Researcher) currentUser;
                        researcher.participateInProject(newProject);
                        if (researcher instanceof User) {
                            User userParticipant = (User) researcher;
                            printLocalizedText("You, " + userParticipant.getName() + ", successfully created a research project and became a participant in it.",
                                    "Вы, " + userParticipant.getName() + ", успешно создали исследовательский проект и стали его участником.",
                                    "Сіз, " + userParticipant.getName() + ", ғылыми жобаны сәтті құрып, оған қатысушы болды.");
                        }
                        dataStore.addResearchProject(newProject);
                    }
                    else {
                        printLocalizedText("Your current role does not allow you to participate in research projects.",
                                "Ваша текущая роль не позволяет участвовать в исследовательских проектах.",
                                "Сіздің қазіргі рөліңіз ғылыми жобаларға қатысуға мүмкіндік бермейді.");
                    }
                    saveUniversityData(dataStore);
                    break;
                case 9:
                    printLocalizedText("Enter the name of your research project to view:",
                            "Введите название исследовательского проекта для просмотра:",
                            "Көру үшін зерттеу жобаңыздың атын енгізіңіз:");
                    String projectNameForView = scanner.nextLine();
                    ResearchProject projectToView = dataStore.getProjectByTitle(projectNameForView);

                    if (projectToView != null) {
                        printLocalizedText("Project information:",
                                "Информация о проекте:",
                                "Жоба туралы ақпарат:");
                        printLocalizedText("Name: " + projectToView.getTitle(),
                                "Название: " + projectToView.getTitle(),
                                "Аты: " + projectToView.getTitle());
                        printLocalizedText("Theme: " + projectToView.getTheme(),
                                "Тема: " + projectToView.getTheme(),
                                "Тақырып: " + projectToView.getTheme());
                        printLocalizedText("Participants:",
                                "Участники:",
                                "Қатысушылар:");
                        for (Researcher participant : projectToView.getParticipants()) {
                            if (participant instanceof User) {
                                User userParticipant = (User) participant;
                                System.out.println(userParticipant.getName());
                            }
                            else {
                                // Вывод дополнительной информации, если участник не является пользователем
                                printLocalizedText("Participant: " + participant.toString(),
                                        "Участник: " + participant.toString(),
                                        "Қатысушы: " + participant.toString());
                            }
                        }
                        printLocalizedText("Scientific works in the project:",
                                "Научные работы в проекте:",
                                "Жобадағы ғылыми жұмыстар:");
                        List<ResearchPaper> papers = projectToView.getPublishedPapers();
                        if (papers.isEmpty()) {
                            printLocalizedText("There are no scientific works.",
                                    "Научные работы отсутствуют.",
                                    "Ғылыми еңбектері жоқ.");
                        }
                        else {
                            for (ResearchPaper paper : papers) {
                                printLocalizedText("Job title: " + paper.getTitle() + ", Authors: " + String.join(", ", paper.getAuthors()) +
                                                ", Publication date: " + paper.getPublishedDate() + ", Annotation: " + paper.getAbstractText(),
                                        "Название работы: " + paper.getTitle() + ", Авторы: " + String.join(", ", paper.getAuthors()) +
                                                ", Дата публикации: " + paper.getPublishedDate() + ", Аннотация: " + paper.getAbstractText(),
                                        "Қызмет атауы: " + paper.getTitle() + ", Авторлар: " + String.join(", ", paper.getAuthors()) +
                                                ", Жарияланған күні: " + paper.getPublishedDate() + ", Аннотация: " + paper.getAbstractText());
                            }
                        }
                    }
                    else {
                        printLocalizedText("Project not found.",
                                "Проект не найден.",
                                "Жоба табылмады.");
                    }
                    break;
                case 10:
                    printLocalizedText("Choose language: 1. English, 2. Russian, 3. Kazakh",
                            "Выберите язык: 1. Английский, 2. Русский, 3. Казахский.",
                            "Тілді таңдаңыз: 1. Ағылшын, 2. Орыс, 3. Қазақ");
                    int langChoice = scanner.nextInt();
                    Language selectedLanguage = Language.values()[langChoice - 1];
                    currentUser.changeLanguage(selectedLanguage);
                    printLocalizedText("Language changed to: " + selectedLanguage,
                            "Язык изменен на: " + selectedLanguage,
                            "Тіл өзгертілді: " + selectedLanguage);
                    saveUniversityData(dataStore);
                    break;
                case 11:
                    graduateMenuActive = false;
                    break;
                default:
                    printLocalizedText("Invalid choice. Please try again.",
                            "Неверный выбор. Пожалуйста, попробуйте еще раз.",
                            "Жарамсыз таңдау. Қайталап көріңіз.");
            }
        }
    }
    private static void displayTeacherMenu(Scanner scanner) {
        Teacher teacher = (Teacher) currentUser;
        boolean teacherMenuActive = true;
        while (teacherMenuActive) {
            printLocalizedText("Teacher Menu:",
                    "Меню учителя:",
                    "Мұғалім мәзірі:");
            printLocalizedText("1. View My Courses",
                    "1. Посмотреть мои курсы",
                    "1. Менің курстарымды көру");
            printLocalizedText("2. Put marks",
                    "2. Поставить оценки",
                    "2. Белгілерді қойыңыз");
            printLocalizedText("3. Create a Course",
                    "3. Создать курс",
                    "3. Курс құру");
            printLocalizedText("4. Engage in research activities",
                    "4. Engage in research activities",
                    "4. Ғылыми-зерттеу қызметімен айналысу");
            printLocalizedText("5. Change Language",
                    "5. Изменить язык",
                    "5. Тілді өзгерту");
            printLocalizedText("6. Logout",
                    "6. Выход из системы",
                    "6. Шығу");
            printLocalizedText("Please choose an option:",
                    "Пожалуйста, выберите опцию:",
                    "Опцияны таңдаңыз:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (choice) {
                case 1:
                    viewTeacherCourses(teacher);
                    break;
                case 2:
                    // Логика для оценки студентов
                    break;
                case 3:
                    addNewCourse(scanner, teacher);
                    break;
                case 4:
                    displayResearchMenu(scanner);
                    break;
                case 5:
                    printLocalizedText("Choose language: 1. English, 2. Russian, 3. Kazakh",
                            "Выберите язык: 1. Английский, 2. Русский, 3. Казахский.",
                            "Тілді таңдаңыз: 1. Ағылшын, 2. Орыс, 3. Қазақ");
                    int langChoice = scanner.nextInt();
                    Language selectedLanguage = Language.values()[langChoice - 1];
                    currentUser.changeLanguage(selectedLanguage);
                    printLocalizedText("Language changed to: " + selectedLanguage,
                            "Язык изменен на: " + selectedLanguage,
                            "Тіл өзгертілді: " + selectedLanguage);
                    saveUniversityData(dataStore);
                    break;
                case 6:
                    teacherMenuActive = false;
                    break;
                default:
                    printLocalizedText("Invalid choice. Please try again.",
                            "Неверный выбор. Пожалуйста, попробуйте еще раз.",
                            "Жарамсыз таңдау. Қайталап көріңіз.");
            }
        }
    }

    private static void displayAdminMenu(Scanner scanner) {
        boolean adminMenuActive = true;
        while (adminMenuActive) {
            saveUniversityData(dataStore);
            printLocalizedText("Admin Menu:",
                    "Меню администратора:",
                    "Әкімші мәзірі:");
            printLocalizedText("1. Create User",
                    "1. Создать пользователя",
                    "1. Пайдаланушы жасау");
            printLocalizedText("2. Delete User",
                    "2. Удалить пользователя",
                    "2. Пайдаланушыны жою");
            printLocalizedText("3. Assign Role to User",
                    "3. Назначьте роль пользователю",
                    "3. Рөлді пайдаланушыға тағайындаңыз");
            printLocalizedText("4. View Logs",
                    "4. Просмотр логов",
                    "4. Логдарды қарау");
            printLocalizedText("5. View All Users",
                    "5. View All Users",
                    "5. View All Users");
            printLocalizedText("6. Change Language",
                    "6. Изменить язык",
                    "6. Тілді өзгерту");
            printLocalizedText("7. Logout",
                    "7. Выход из системы",
                    "7. Шығу");
            printLocalizedText("Please choose an option:",
                    "Пожалуйста, выберите опцию:",
                    "Опцияны таңдаңыз:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (choice) {
                case 1:
                    printLocalizedText("Enter your username:",
                            "Введите имя пользователя:",
                            "Пайдаланушы атыңызды енгізіңіз:");
                    String name = scanner.nextLine();

                    printLocalizedText("Enter user email:",
                            "Введите почту пользователя:",
                            "Пайдаланушы электрондық поштасын енгізіңіз:");
                    String email = scanner.nextLine();

                    printLocalizedText("Enter password:",
                            "Введите пароль:",
                            "Құпия сөзді еңгізіңіз:");
                    String password = scanner.nextLine();

                    printLocalizedText("Select the user type (1 - Student, 2 - Graduate Student, 3 - Administrator, " +
                            "4 - Tech. Support, 5 - Teacher, 6 - Manager):",
                            "Выберите тип пользователя (1 - Студент, 2 - Аспирант, 3 - Админ, " +
                                    "4 - Тех. Поддержка, 5 - Преподаватель, 6 - Менеджер):",
                            "Пайдаланушы түрін таңдаңыз (1 - студент, 2 - магистрант, 3 - әкімші, " +
                                    "4 - Тех. Қолдау, 5 – Мұғалім, 6 – Менеджер):");
                    int userType = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера сканера

                    UserType selectedUserType = UserType.values()[userType - 1];
                    String employeeId = UUID.randomUUID().toString();
                    Schools school = null;
                    DegreeType degreeType = null;

                    int schoolChoice;
                    int degreeChoice;

                    if (userType <= 2) {
                        printLocalizedText("Select student's department: \n" +
                                "1 - SITE School of Information Technology and Engineering \n" +
                                "2 - BS School of Business\n" +
                                "3 - SEOGI School of Ecology and Geology\n" +
                                "4 - KMA Maritime Academy School\n" +
                                "5 - ISE School of Industrial Systems Engineering\n" +
                                "6 - SAM School of Aviation and Navigation\n" +
                                "7 - SMSGT School of Marine Systems and Geotechnology\n" +
                                "8 - SCE School of Civil Engineering\n" +
                                "9 - SNSS School of Science",
                                "Выберите факультет студента: \n" +
                                        "1 - SITE Школа информационных технологий и инженерии \n" +
                                        "2 - BS Школа бизнеса\n" +
                                        "3 - SEOGI Школа экологии и геологии\n" +
                                        "4 - KMA Школа морской академии\n" +
                                        "5 - ISE Школа индустриальной системы инженерии\n" +
                                        "6 - SAM Школа авиации и мореходства\n" +
                                        "7 - SMSGT Школа морских систем и геотехнологий\n" +
                                        "8 - SCE Школа гражданского строительства\n" +
                                        "9 - SNSS Школа естественных наук",
                                "Студенттік бөлімді таңдаңыз: \n" +
                                        "1 - SITE Ақпараттық технологиялар және инженерия мектебі \n" +
                                        "2 - BS Бизнес мектебі\n" +
                                        "3 - SEOGI Экология және геология мектебі\n" +
                                        "4 - KMA Теңіз академиясының мектебі\n" +
                                        "5 - ISE Өнеркәсіптік жүйелер инженерия мектебі\n" +
                                        "6 - SAM Авиация және навигация мектебі\n" +
                                        "7 - SMSGT Теңіз жүйелері және геотехнология мектебі\n" +
                                        "8 - SCE Құрылыс мектебі\n" +
                                        "9 - SNSS Ғылым мектебі");
                        schoolChoice = scanner.nextInt();
                        switch (schoolChoice) {
                            case 1:
                                school = Schools.SITE;
                                break;
                            case 2:
                                school = Schools.BS;
                                break;
                            case 3:
                                school = Schools.SEOGI;
                                break;
                            case 4:
                                school = Schools.KMA;
                                break;
                            case 5:
                                school = Schools.ISE;
                                break;
                            case 6:
                                school = Schools.SAM;
                                break;
                            case 7:
                                school = Schools.SMSGT;
                                break;
                            case 8:
                                school = Schools.SCE;
                                break;
                            case 9:
                                school = Schools.SNSS;
                                break;
                            default:
                                printLocalizedText("Invalid choice. Please try again.",
                                        "Неверный выбор. Пожалуйста, попробуйте еще раз.",
                                        "Жарамсыз таңдау. Қайталап көріңіз.");
                        }
                    }
                    if (userType == 2) {
                        printLocalizedText("Select degree:  \n 1 - PHD \n 2 - Master",
                                "Выберите степень:  \n 1 - PHD \n 2 - Master",
                                "Дәрежені таңдаңыз:  \n 1 - PHD \n 2 - Master");
                        degreeChoice = scanner.nextInt();
                        switch (degreeChoice) {
                            case 1:
                                degreeType = DegreeType.PHD;
                                break;
                            case 2:
                                degreeType = DegreeType.MASTER;
                                break;
                            default:
                                printLocalizedText("Invalid choice. Please try again.",
                                        "Неверный выбор. Пожалуйста, попробуйте еще раз.",
                                        "Жарамсыз таңдау. Қайталап көріңіз.");
                        }
                    }

                    DepartmentType department = userType > 2 ? DepartmentType.values()[userType - 3] : null;
                    ConcreteUserFactory userFactory = ConcreteUserFactory.getInstance();
                    User newUser = userFactory.createUser(selectedUserType, name, email, password, employeeId, department, school, degreeType, Language.EN, dataStore);

                    if (newUser != null) {
                        dataStore.addUser(newUser);
                        printLocalizedText("Пользователь создан: " + newUser.toString(),
                                "Пользователь создан: " + newUser.toString(),
                                "Пользователь создан: " + newUser.toString());
                    }
                    else {
                        printLocalizedText("Error creating user.",
                                "Ошибка при создании пользователя.",
                                "Пайдаланушыны жасау қатесі.");
                    }
                    break;
                case 2:
                    printLocalizedText("Enter the user's email to delete:",
                            "Введите email пользователя для удаления:",
                            "Жою үшін пайдаланушының электрондық поштасын енгізіңіз:");
                    String userEmailToDelete = scanner.nextLine();
                    User userToDelete = dataStore.getUserByEmail(userEmailToDelete);

                    if (userToDelete != null) {
                        dataStore.deleteUser(userToDelete);
                        printLocalizedText("The user was successfully deleted.",
                                "Пользователь успешно удален.",
                                "Пайдаланушы сәтті жойылды.");
                    }
                    else {
                        printLocalizedText("A user with this email was not found.",
                                "Пользователь с таким email не найден.",
                                "Осы электрондық поштасы бар пайдаланушы табылмады.");
                    }
                    break;
                case 3:
                    printLocalizedText("Enter the user's email to change the role:",
                            "Введите email пользователя для изменения роли:",
                            "Рөлді өзгерту үшін пайдаланушының электрондық поштасын енгізіңіз:");
                    String userEmail = scanner.nextLine();
                    User userToChange = dataStore.getUserByEmail(userEmail);

                    if (userToChange != null) {
                        printLocalizedText("Choose a new role (1 - Student, 2 - Graduate Student, 3 - Administrator, " +
                                        "4 - Tech. Support, 5 - Teacher, 6 - Manager):",
                                "Выберите новую роль (1 - Студент, 2 - Аспирант, 3 - Админ, " +
                                        "4 - Тех. Поддержка, 5 - Преподаватель, 6 - Менеджер):",
                                "Жаңа рөлді таңдаңыз (1 - студент, 2 - магистрант, 3 - әкімші, " +
                                        "4 - Тех. Қолдау, 5 – Мұғалім, 6 – Менеджер):");
                        int newRole = scanner.nextInt();
                        scanner.nextLine(); // Очистка буфера сканера

                        selectedUserType = UserType.values()[newRole - 1];
                        String futureEmployeeId = UUID.randomUUID().toString();
                        school = null;
                        degreeType = null;
                        if (newRole == 1 || newRole == 2) {
                            printLocalizedText("Select student's department: \n" +
                                            "1 - SITE School of Information Technology and Engineering \n" +
                                            "2 - BS School of Business\n" +
                                            "3 - SEOGI School of Ecology and Geology\n" +
                                            "4 - KMA Maritime Academy School\n" +
                                            "5 - ISE School of Industrial Systems Engineering\n" +
                                            "6 - SAM School of Aviation and Navigation\n" +
                                            "7 - SMSGT School of Marine Systems and Geotechnology\n" +
                                            "8 - SCE School of Civil Engineering\n" +
                                            "9 - SNSS School of Science",
                                    "Выберите факультет студента: \n" +
                                            "1 - SITE Школа информационных технологий и инженерии \n" +
                                            "2 - BS Школа бизнеса\n" +
                                            "3 - SEOGI Школа экологии и геологии\n" +
                                            "4 - KMA Школа морской академии\n" +
                                            "5 - ISE Школа индустриальной системы инженерии\n" +
                                            "6 - SAM Школа авиации и мореходства\n" +
                                            "7 - SMSGT Школа морских систем и геотехнологий\n" +
                                            "8 - SCE Школа гражданского строительства\n" +
                                            "9 - SNSS Школа естественных наук",
                                    "Студенттік бөлімді таңдаңыз: \n" +
                                            "1 - SITE Ақпараттық технологиялар және инженерия мектебі \n" +
                                            "2 - BS Бизнес мектебі\n" +
                                            "3 - SEOGI Экология және геология мектебі\n" +
                                            "4 - KMA Теңіз академиясының мектебі\n" +
                                            "5 - ISE Өнеркәсіптік жүйелер инженерия мектебі\n" +
                                            "6 - SAM Авиация және навигация мектебі\n" +
                                            "7 - SMSGT Теңіз жүйелері және геотехнология мектебі\n" +
                                            "8 - SCE Құрылыс мектебі\n" +
                                            "9 - SNSS Ғылым мектебі");
                            schoolChoice = scanner.nextInt();
                            scanner.nextLine(); // Очистка буфера сканера
                            school = Schools.values()[schoolChoice - 1];
                            if (newRole == 2) {
                                printLocalizedText("Select degree:  \n 1 - PHD \n 2 - Master",
                                        "Выберите степень:  \n 1 - PHD \n 2 - Master",
                                        "Дәрежені таңдаңыз:  \n 1 - PHD \n 2 - Master");
                                degreeChoice = scanner.nextInt();
                                scanner.nextLine(); // Очистка буфера сканера
                                degreeType = DegreeType.values()[degreeChoice - 1];
                            }
                        }
                        department = newRole > 2 ? DepartmentType.values()[newRole - 3] : null;
                        // Использование фабрики для создания обновленного пользователя
                        userFactory = ConcreteUserFactory.getInstance();
                        User updatedUser = userFactory.createUser(selectedUserType, userToChange.getName(), userToChange.getEmail(), userToChange.getPassword(), futureEmployeeId, department, school, degreeType, Language.EN, dataStore);

                        if (updatedUser != null) {
                            dataStore.replaceUser(userEmail, updatedUser);
                            printLocalizedText("User role updated: " + updatedUser.toString(),
                                    "Роль пользователя обновлена: " + updatedUser.toString(),
                                    "Пайдаланушы рөлі жаңартылды: " + updatedUser.toString());
                        }
                        else {
                            printLocalizedText("Error updating role.",
                                    "Ошибка при обновлении роли.",
                                    "Рөлді жаңарту қатесі.");
                        }
                    }
                    else {
                        printLocalizedText("User is not found.",
                                "Пользователь не найден.",
                                "Пайдаланушы табылмады.");
                    }
                    break;
                case 4:
                    // Логика для просмотра логов
                    break;
                case 5:
                    ((Admin) currentUser).viewAllUsers();
                    break;
                case 6:
                    printLocalizedText("Choose language: 1. English, 2. Russian, 3. Kazakh",
                            "Выберите язык: 1. Английский, 2. Русский, 3. Казахский.",
                            "Тілді таңдаңыз: 1. Ағылшын, 2. Орыс, 3. Қазақ");
                    int langChoice = scanner.nextInt();
                    Language selectedLanguage = Language.values()[langChoice - 1];
                    currentUser.changeLanguage(selectedLanguage);
                    printLocalizedText("Language changed to: " + selectedLanguage,
                            "Язык изменен на: " + selectedLanguage,
                            "Тіл өзгертілді: " + selectedLanguage);
                    saveUniversityData(dataStore);
                    break;
                case 7:
                    adminMenuActive = false;
                    break;
                default:
                    printLocalizedText("Invalid choice. Please try again.",
                            "Неверный выбор. Пожалуйста, попробуйте еще раз.",
                            "Жарамсыз таңдау. Қайталап көріңіз.");
            }
        }
    }

    private static void saveUniversityData(UniversityDataStore dataStore) { // Сохранение данных
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("universityData.ser"))) {
            oos.writeObject(dataStore);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving university data", e);
        }
    }
    private static UniversityDataStore loadUniversityData() { // Загрузка данных
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_STORE_PATH))) {
            return (UniversityDataStore) ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println("Data store file not found. A new one will be created.");
            return new UniversityDataStore();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading university data", e);
        }
    }
    private static void displayResearchMenu(Scanner scanner) {
        boolean researchMenuActive = true;
        while (researchMenuActive) {
            printLocalizedText("Research Activities Menu:",
                    "Меню исследовательской деятельности:",
                    "Зерттеу жұмысының мәзірі:");
            printLocalizedText("1. View Research Projects",
                    "1. Просмотр исследовательских проектов",
                    "1. Зерттеу жобаларын қарау");
            printLocalizedText("2. Participate in Research Project",
                    "2. Примите участие в исследовательском проекте.",
                    "2. Зерттеу жобасына қатысу");
            printLocalizedText("3. Publish Research Paper",
                    "3. Опубликовать исследовательскую работу",
                    "3. Зерттеу жұмысын жариялау");
            printLocalizedText("4. View My Research Activities",
                    "4. Просмотр моей исследовательской деятельности",
                    "4. Менің зерттеу әрекеттерімді қарау");
            printLocalizedText("5. Create a Research project",
                    "5. Создайте исследовательский проект",
                    "5. Зерттеу жобасын жасаңыз");
            printLocalizedText("6. Research journal",
                    "6. Научный журнал",
                    "6. Зерттеу журналы");
            printLocalizedText("7. Return to Main Menu",
                    "7. Вернуться в главное меню.",
                    "7. Негізгі мәзірге оралыңыз");
            printLocalizedText("Please choose an option:",
                    "Пожалуйста, выберите опцию:",
                    "Опцияны таңдаңыз:");

            int researchChoice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (researchChoice) {
                case 1:
                    List<ResearchProject> projects = dataStore.getResearchProjects();
                    if (projects.isEmpty()) {
                        printLocalizedText("There are no research projects available at this time.",
                                "На данный момент нет доступных исследовательских проектов.",
                                "Қазіргі уақытта ғылыми жобалар жоқ.");
                    }
                    else {
                        printLocalizedText("Available research projects:",
                                "Доступные исследовательские проекты:",
                                "Қолжетімді ғылыми жобалар:");
                        for (ResearchProject project : projects) {
                            System.out.println("ID: " + project.getProjectId());
                            printLocalizedText("Name: " + project.getTitle(), "Название: " + project.getTitle(), "Аты: " + project.getTitle());
                            printLocalizedText("Theme: " + project.getTheme(), "Тема: " + project.getTheme(), "Тақырып: " + project.getTheme());
                        }
                    }
                    saveUniversityData(dataStore);
                    break;
                case 2:
                    printLocalizedText("Enter the name of the research project to participate:",
                            "Введите название исследовательского проекта для участия:",
                            "Қатысу үшін ғылыми жобаның атын енгізіңіз:");
                    String projectName = scanner.nextLine();
                    ResearchProject projectToJoin = dataStore.getProjectByTitle(projectName);

                    if (projectToJoin != null) {
                        if (currentUser instanceof Researcher) {
                            Researcher researcher = (Researcher) currentUser;
                            // Проверка, участвует ли пользователь уже в проекте
                            if (!researcher.getResearchProjects().contains(projectToJoin)) {
                                researcher.participateInProject(projectToJoin);
                                if (researcher instanceof User) {
                                    User userParticipant = (User) researcher;
                                    printLocalizedText("A new member has been added to the project:" + userParticipant.getName(),
                                            "Добавлен новый участник в проект: " + userParticipant.getName(),
                                            "Жобаға жаңа мүше қосылды:" + userParticipant.getName());
                                }
                                printLocalizedText("You have successfully joined the project: " + projectName,
                                        "Вы успешно присоединились к проекту: " + projectName,
                                        "Сіз жобаға сәтті қосылдыңыз: " + projectName);
                            }
                            else {
                                printLocalizedText("You are already a participant in this project.",
                                        "Вы уже участник данного проекта.",
                                        "Сіз бұл жобаның қатысушысысыз.");
                            }
                        }
                        else {
                            printLocalizedText("Your current role does not allow you to participate in projects.",
                                    "Ваша текущая роль не позволяет участвовать в проектах.",
                                    "Сіздің қазіргі рөліңіз жобаларға қатысуға мүмкіндік бермейді.");
                        }
                    }
                    else {
                        printLocalizedText("Project not found.",
                                "Проект не найден.",
                                "Жоба табылмады.");
                    }
                    saveUniversityData(dataStore);
                    break;
                case 3:
                    printLocalizedText("Enter the project ID for your research paper:",
                            "Введите идентификатор проекта для вашей исследовательской работы:",
                            "Зерттеу жұмысыңыз үшін жоба идентификаторын енгізіңіз:");
                    String projectIdTemp = scanner.nextLine();
                    ResearchProject selectedProject = dataStore.getProjectById(projectIdTemp);

                    if (selectedProject != null) {
                        if (currentUser instanceof Researcher && ((Researcher) currentUser).getResearchProjects().contains(selectedProject)) {
                            printLocalizedText("Enter information about the scientific work: Title, abstract, number of pages, DOI, publication date (yyyy-mm-dd)",
                                    "Введите информацию о научной работе: Название, аннотацию, количество страниц, DOI, дату публикации (гггг-мм-дд)",
                                    "Ғылыми жұмыс туралы ақпаратты енгізіңіз: Тақырып, реферат, беттер саны, DOI, жарияланған күні (жжжж-мм-кк)");
                            String paperId = UUID.randomUUID().toString();
                            String title = scanner.nextLine();
                            String abstractText = scanner.nextLine();
                            int pageCount = scanner.nextInt();
                            scanner.nextLine(); // Очистка буфера
                            String doi = scanner.nextLine();
                            String dateStr = scanner.nextLine();

                            // Конвертация строки в Date
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            Date publishedDate;
                            try {
                                publishedDate = formatter.parse(dateStr);
                            }
                            catch (ParseException e) {
                                printLocalizedText("Invalid date format.",
                                        "Неверный формат даты.",
                                        "Күн пішімі жарамсыз.");
                                break;
                            }

                            // Создание списка авторов
                            List<String> authors = new ArrayList<>();
                            printLocalizedText("Enter the number of authors:",
                                    "Введите количество авторов:",
                                    "Авторлар санын енгізіңіз:");
                            int authorsCount = scanner.nextInt();
                            scanner.nextLine(); // Очистка буфера
                            for (int i = 0; i < authorsCount; i++) {
                                System.out.println("Введите имя автора " + (i + 1) + ":");
                                authors.add(scanner.nextLine());
                            }

                            ResearchPaper paper = new ResearchPaper(paperId, title, authors, abstractText, pageCount, doi, publishedDate);
                            if (currentUser instanceof Researcher) {
                                Researcher researcher = (Researcher) currentUser;
                                researcher.addPublishedPaper(paper); // Добавляем работу в список опубликованных работ исследователя
                                selectedProject.addPaper(paper); // Добавляем работу в проект
                                dataStore.updateResearchProject(selectedProject); // Обновление проекта с новой работой
                                UniversitySystemApp.saveUniversityData(dataStore); // Сохранение изменений в системе
                                printLocalizedText("Scientific work has been added to the project.",
                                        "Научная работа добавлена в проект.",
                                        "Жобаға ғылыми жұмыстар қосылды.");
                            }
                            else {
                                printLocalizedText("Only researchers can publish work.",
                                        "Только исследователи могут публиковать работы.",
                                        "Жұмысты тек зерттеушілер ғана жариялай алады.");
                            }
                        }
                        else {
                            printLocalizedText("You cannot publish work on a project in which you are not involved.",
                                    "Вы не можете публиковать работы в проекте, в котором не участвуете.",
                                    "Сіз қатыспаған жобадағы жұмысты жариялай алмайсыз.");
                        }
                    }
                    else {
                        printLocalizedText("Project not found.",
                                "Проект не найден.",
                                "Жоба табылмады.");
                    }
                    saveUniversityData(dataStore);
                    break;

                case 4:
                    if (currentUser instanceof Researcher) {
                        Researcher researcher = (Researcher) currentUser;
                        printLocalizedText("Published works:",
                                "Опубликованные работы:",
                                "Жарияланған жұмыстар:");
                        for (ResearchPaper paper : researcher.getPublishedPapers()) {
                            System.out.println(paper.getTitle() + " - " + paper.getPublishedDate());
                        }
                        printLocalizedText("Research projects:",
                                "Исследовательские проекты:",
                                "Ғылыми жобалар:");
                        for (ResearchProject projectTemp : researcher.getResearchProjects()) {
                            System.out.println(projectTemp.getTitle() + " - " + projectTemp.getTheme());
                        }
                    }
                    else {
                        printLocalizedText("Only researchers have research activities.",
                                "Только исследователи имеют исследовательскую деятельность.",
                                "Тек зерттеушілер ғана ғылыми-зерттеу қызметімен айналысады.");
                    }
                    saveUniversityData(dataStore);
                    break;
                case 5:
                    printLocalizedText("Enter the name of the research project:",
                            "Введите название исследовательского проекта:",
                            "Зерттеу жобасының атын енгізіңіз:");
                    String projectNameTemp = scanner.nextLine();
                    printLocalizedText("Enter your research topic:",
                            "Введите тему исследования:",
                            "Зерттеу тақырыбыңызды енгізіңіз:");
                    String researchTheme = scanner.nextLine();

                    // Генерация уникального ID для проекта
                    String projectIdGen = UUID.randomUUID().toString();

                    // Создание нового исследовательского проекта
                    ResearchProject newProject = new ResearchProject(projectIdGen, projectNameTemp, researchTheme);

                    // Добавление текущего пользователя как участника проекта, если он может быть исследователем
                    if (currentUser instanceof Researcher) {
                        Researcher researcher = (Researcher) currentUser;
                        researcher.participateInProject(newProject);
                        if (researcher instanceof User) {
                            User userParticipant = (User) researcher;
                            printLocalizedText("You, " + userParticipant.getName() + ", successfully created a research project and became a participant in it.",
                                    "Вы, " + userParticipant.getName() + ", успешно создали исследовательский проект и стали его участником.",
                                    "Сіз, " + userParticipant.getName() + ", ғылыми жобаны сәтті құрып, оған қатысушы болды.");
                        }
                        dataStore.addResearchProject(newProject);
                    }
                    else {
                        printLocalizedText("Your current role does not allow you to participate in research projects.",
                                "Ваша текущая роль не позволяет участвовать в исследовательских проектах.",
                                "Сіздің қазіргі рөліңіз ғылыми жобаларға қатысуға мүмкіндік бермейді.");
                    }
                    saveUniversityData(dataStore);
                    break;
                case 6:
                    printLocalizedText("Enter the name of your research project to view:",
                            "Введите название исследовательского проекта для просмотра:",
                            "Көру үшін зерттеу жобаңыздың атын енгізіңіз:");
                    String projectNameForView = scanner.nextLine();
                    ResearchProject projectToView = dataStore.getProjectByTitle(projectNameForView);

                    if (projectToView != null) {
                        printLocalizedText("Project information:",
                                "Информация о проекте:",
                                "Жоба туралы ақпарат:");
                        printLocalizedText("Name: " + projectToView.getTitle(),
                                "Название: " + projectToView.getTitle(),
                                "Аты: " + projectToView.getTitle());
                        printLocalizedText("Theme: " + projectToView.getTheme(),
                                "Тема: " + projectToView.getTheme(),
                                "Тақырып: " + projectToView.getTheme());
                        printLocalizedText("Participants:",
                                "Участники:",
                                "Қатысушылар:");
                        for (Researcher participant : projectToView.getParticipants()) {
                            if (participant instanceof User) {
                                User userParticipant = (User) participant;
                                System.out.println(userParticipant.getName());
                            }
                            else {
                                // Вывод дополнительной информации, если участник не является пользователем
                                printLocalizedText("Participant: " + participant.toString(),
                                        "Участник: " + participant.toString(),
                                        "Қатысушы: " + participant.toString());
                            }
                        }
                        printLocalizedText("Scientific works in the project:",
                                "Научные работы в проекте:",
                                "Жобадағы ғылыми жұмыстар:");
                        List<ResearchPaper> papers = projectToView.getPublishedPapers();
                        if (papers.isEmpty()) {
                            printLocalizedText("There are no scientific works.",
                                    "Научные работы отсутствуют.",
                                    "Ғылыми еңбектері жоқ.");
                        }
                        else {
                            for (ResearchPaper paper : papers) {
                                printLocalizedText("Job title: " + paper.getTitle() + ", Authors: " + String.join(", ", paper.getAuthors()) +
                                                ", Publication date: " + paper.getPublishedDate() + ", Annotation: " + paper.getAbstractText(),
                                        "Название работы: " + paper.getTitle() + ", Авторы: " + String.join(", ", paper.getAuthors()) +
                                                ", Дата публикации: " + paper.getPublishedDate() + ", Аннотация: " + paper.getAbstractText(),
                                        "Қызмет атауы: " + paper.getTitle() + ", Авторлар: " + String.join(", ", paper.getAuthors()) +
                                                ", Жарияланған күні: " + paper.getPublishedDate() + ", Аннотация: " + paper.getAbstractText());
                            }
                        }
                    }
                    else {
                        printLocalizedText("Project not found.",
                                "Проект не найден.",
                                "Жоба табылмады.");
                    }
                    break;
                case 7:
                    researchMenuActive = false;
                    break;
                default:
                    printLocalizedText("Invalid choice. Please try again.",
                            "Неверный выбор. Пожалуйста, попробуйте еще раз.",
                            "Жарамсыз таңдау. Қайталап көріңіз.");
            }
        }
    }
    private static void viewAvailableCourses() {
        List<Course> availableCourses = dataStore.getAllCourses();
        if (availableCourses.isEmpty()) {
            printLocalizedText("There are no available courses at the moment.",
                    "На данный момент доступных курсов нет.",
                    "Қазіргі уақытта қолжетімді курстар жоқ.");
        }
        else {
            printLocalizedText("Available Courses:",
                    "Доступные курсы:",
                    "Қолжетімді курстар:");
            for (Course course : availableCourses) {
                String teacherName = course.getTeacher() != null ? course.getTeacher().getName() : "N/A";
                printLocalizedText("Title: " + course.getTitle() + ", Teacher: " + teacherName + ", Credits: " + course.getCredits() + ", Type: " + course.getCourseType() + ", Description: " + course.getDescription(),
                        "Название: " + course.getTitle() + ", Преподаватель: " + teacherName + ", Кредиты: " + course.getCredits() + ", Тип: " + course.getCourseType() + ", Описание: " + course.getDescription(),
                        "Тақырып: " + course.getTitle() + ", Мұғалім: " + teacherName + ", Несиелер: " + course.getCredits() + ", Түр: " + course.getCourseType() + ", Сипаттама: " + course.getDescription());
            }
        }
    }

    private static void applyForCourse(Scanner scanner) {
        printLocalizedText("Enter the name of the course you want to apply for:",
                "Введите название курса, на который хотите подать заявку:",
                "Өтініш бергіңіз келетін курстың атын енгізіңіз:");
        String courseTitle = scanner.nextLine();

        Course course = dataStore.getCourseByTitle(courseTitle);
        if (course == null) {
            printLocalizedText("Course not found.",
                    "Курс не найден.",
                    "Курс табылмады.");
            return;
        }

        if (currentUser instanceof Student) {
            Student student = (Student) currentUser;
            if (student.canEnrollInCourse(course)) {
                Manager manager = dataStore.getManagers().get(0); // Получаем например первого менеджера
                student.applyForCourse(course, manager);
                printLocalizedText("Application for a course " + course.getTitle() + " sent.",
                        "Заявка на курс " + course.getTitle() + " отправлена.",
                        "Курсқа өтініш " + course.getTitle() + " жіберілді.");
            }
            else {
                printLocalizedText("You are unable to enroll in this course due to credit restrictions.",
                        "Вы не можете записаться на этот курс из-за ограничения по кредитам.",
                        "Несие шектеулеріне байланысты бұл курсқа жазыла алмайсыз.");
            }
        }
        else {
            printLocalizedText("Only students can apply for courses.",
                    "Только студенты могут подавать заявки на курсы.",
                    "Курстарға тек студенттер өтініш бере алады.");
        }
        saveUniversityData(dataStore);
    }
    private static void addNewCourse(Scanner scanner, Teacher teacher) {
        printLocalizedText("Enter course name:",
                "Введите название курса:",
                "Курс атын енгізіңіз:");
        String title = scanner.nextLine();

        printLocalizedText("Enter course description:",
                "Введите описание курса:",
                "Курс сипаттамасын енгізіңіз:");
        String description = scanner.nextLine();

        printLocalizedText("Enter the number of course credits:",
                "Введите количество кредитов курса:",
                "Курс кредиттерінің санын енгізіңіз:");
        int credits = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        printLocalizedText("Select the type of course (1 - Major, 2 - Minor, 3 - Free):",
                "Выберите тип курса (1 - Major, 2 - Minor, 3 - Free):",
                "Курс түрін таңдаңыз (1 - Major, 2 - Minor, 3 - Free):");
        int courseTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        CourseType courseType = CourseType.values()[courseTypeChoice - 1];

        printLocalizedText("Does the course have prerequisites? (1 - yes, 2 - no)",
                "Есть ли у курса пререквизит? (1 - да, 2 - нет)",
                "Курстың пререквизиттері бар ма? (1 – иә, 2 – жоқ)");
        String hasPrerequisite = scanner.nextLine();
        Course prerequisite = null;

        if (hasPrerequisite.equalsIgnoreCase("1")) {
            printLocalizedText("Enter the name of the prerequisite:",
                    "Введите название пререквизита:",
                    "Алғы шарттың атын енгізіңіз:");
            String prerequisiteTitle = scanner.nextLine();
            prerequisite = dataStore.getCourseByTitle(prerequisiteTitle);

            if (prerequisite == null) {
                printLocalizedText("Prerequisite not found. Creating a course without prerequisites.",
                        "Пререквизит не найден. Создание курса без пререквизита.",
                        "Алғы шарт табылмады. Пререквизиттерсіз курс құру.");
            }
        }

        // Создание нового курса
        Course newCourse = new Course(title, description, credits, courseType, prerequisite, teacher);

        // Добавление курса в систему
        teacher.addCourseToUniversity(newCourse);
        printLocalizedText("New course added successfully: " + newCourse.getTitle(),
                "Новый курс успешно добавлен: " + newCourse.getTitle(),
                "Жаңа курс сәтті қосылды: " + newCourse.getTitle());
        saveUniversityData(dataStore);
    }
    private static void viewTeacherCourses(Teacher teacher) {
        List<Course> courses = teacher.getCourses();
        if (courses.isEmpty()) {
            printLocalizedText("You are not teaching any courses currently.",
                    "В настоящее время вы не ведете никаких курсов.",
                    "Сіз қазір ешқандай курсты оқытпайсыз.");
        }
        else {
            printLocalizedText("Courses you are teaching:",
                    "Курсы, которые вы преподаете:",
                    "Сіз оқытатын курстар:");
            for (Course course : courses) {
                printLocalizedText("Title: " + course.getTitle() + ", Credits: " + course.getCredits() + ", Type: " + course.getCourseType(),
                        "Название: " + course.getTitle() + ", Кредиты: " + course.getCredits() + ", Тип: " + course.getCourseType(),
                        "Тақырып: " + course.getTitle() + ", Несиелер: " + course.getCredits() + ", Түр: " + course.getCourseType());
            }
        }
    }

    public static void printLocalizedText(String textEN, String textRU, String textKZ) { // Поддержка трёх языков
        switch (currentUser.getLanguage()) {
            case EN:
                System.out.println(textEN);
                break;
            case RU:
                System.out.println(textRU);
                break;
            case KZ:
                System.out.println(textKZ);
                break;
        }
    }
}
