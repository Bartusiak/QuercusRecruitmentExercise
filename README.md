# QuercusRecruitmentExercise

Zadanie zrobionę "naokoło", ponieważ nie wiem czemu nie mogłem wykorzystać JSF (pewno o wiele łatwiej by to poszło).
W repozytorium znajduje się plik QuercusDatabase, gdzie jest utworzona tabela z zawartością.

W klasie ConnectionManager jeśli będzie potrzeba proszę ustawić adres lokalnej bazy danych, login, hasło by połączyć się.

Po uruchomieniu programu będziemy mieli do wyboru dwie opcje dodanie pracownika i wyświetlenie listy pracowników.
Dodanie pracownika otwiera formularz, gdzie możemy dodać pracownika. Uwaga! Jeśli podamy zły email, aplikacja poinformuje Nas o tym - wystarczy wtedy cofnąć przyciskiem "wstecz" w przeglądarce.
Po pomyślnym dodaniu pracownika, aplikacja przeniesie Nas do widoku głównego i wyświetli informacje o udanym dodaniu pracownika.

Wybierając opcje lista pracowników, przeniesieni zostaniemy do kolejnego widoku, gdzie po naciśnieciu przycisku "Wyświetl listę", zostanie załadowana zawartość bazy danych i opcje "Edytuj" lub "Usuń".
Wybierając "Edytuj" zostajemy przeniesieni do widoku, formularza z aktualnymi danymi, gdzie możemy zmienić wartości. Uwaga ! id jest zablokowane ze względu na to, że baza danych automatycznie dodaje id dla nowych pracowników.
Po zatwierdzeniu zmian aplikacja przeniesie nas do widoku głównego, gdzie otrzymamy informacje o pomyślnej edycji użytkownika.

Jeśli zdecydujemy się na opcję "Usuń", aplikacja od razu usunię element i w widoku głównym powiadomi Nas o pomyślnym usunięciu pracownika.

