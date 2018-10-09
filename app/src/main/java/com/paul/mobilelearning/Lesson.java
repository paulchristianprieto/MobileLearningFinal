package com.paul.mobilelearning;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;
import java.util.Locale;
import java.util.Objects;

public class Lesson extends AppCompatActivity {

    TextView title;
    TextView content;
    TextToSpeech toSpeech;
    int result;
    String text;

    int txtSize = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Intent i = getIntent();
        String activeLessonOrQuiz = i.getStringExtra("lessonOrQuizName");
        String term = i.getStringExtra("term");

        ActionBar actionBar = getSupportActionBar();


        title = (TextView) findViewById(R.id.lessonOrQuizTitle);
        content = (TextView) findViewById(R.id.lessonOrQuizContent);

        toSpeech = new TextToSpeech(Lesson.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    result = toSpeech.setLanguage(Locale.CANADA);
                } else {
                    Toast.makeText(getApplicationContext(), "Feature not supported in you device", Toast.LENGTH_LONG).show();
                }
            }
        });

        if (Objects.equals(activeLessonOrQuiz, "Lesson 1: Fundamental Positions of the Arms and Feet") && Objects.equals(term, "PRELIM")) {
            Intent lesson1 = new Intent(getApplicationContext(), Lesson1.class);
            lesson1.putExtra("lessonOrQuizName", activeLessonOrQuiz);
            startActivity(lesson1);
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 2: Basic Terminologies and Steps in Folk Dances") && Objects.equals(term, "PRELIM")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 2");
            content.setText("BOW OR SALUDO \n" +
                    "\t Partners bow to each other to opposite dancers or to \n" +
                    "\t the audience. This term is of Spanish origin.\n" +
                    "\n" +
                    "·BRUSH \n" +
                    "\tWeight on one foot, swing the free foot in an arch, so \n" +
                    "\tthat the ball or heel strikes the floor at lowest point \n" +
                    "\tof the arch. This may be done forward, sideward, or \n" +
                    "\tbackward.\n" +
                    "\n" +
                    "·CLOCKWISE \n" +
                    "\tLike the motion on the handle of the clock moving to the \n" +
                    "\tleft, when facing the center of an imaginary circle. Right \n" +
                    "\tshoulder is toward the center when moving forward.\n" +
                    "\n" +
                    "·COUNTER CLOCKWISE \n" +
                    "\tThe reverse direction of clockwise, the hands of the clock \n" +
                    "\tmoving to the right, when facing center of an imaginary \n" +
                    "\tcircle when moving forward.\n" +
                    "\n" +
                    "·CUT \n" +
                    "\tQuick change of weight from one foot to the other displacing \n" +
                    "\tthe supporting foot.\n" +
                    "\n" +
                    "·DO-SI-DO or DOS-A-DOS \n" +
                    "\tTwo people walk toward each other, pass by the right shoulder \n" +
                    "\tstep sideward to the right and return to position walking \n" +
                    "\tbackward, passing left shoulder.\n" +
                    "\n" +
                    "·DRAW \n" +
                    "\tThe free foot is drawn toward the foot, which supports the \n" +
                    "\tbody weight, by pressing the toes against the floor as the \n" +
                    "\tclose is made. With or without transfer of weight.\n" +
                    "\n" +
                    "·FREE FOOT\n" +
                    "\tThe foot not supporting the weight of the body.\n" +
                    "\n" +
                    "·FREE HAND \n" +
                    "\tThe hand not doing anything.\n" +
                    "\n" +
                    "·HOP \n" +
                    "\tSpring on the supporting foot, and land on the same foot.\n" +
                    "\n" +
                    "·INSIDE FOOT \n" +
                    "\tThe foot near one's partner when they stand side by side.\n" +
                    "\n" +
                    "·INSIDE HAND \n" +
                    "\tThe hand near one's partner when they stand side by side.\n" +
                    "\n" +
                    "·JUMP \n" +
                    "\tSpring from one or two feet and land on both feet.\n" +
                    "\n" +
                    "·LEAP \n" +
                    "\tSpring on the supporting foot and land on the other foot.\n" +
                    "\n" +
                    "·OUTSIDE FOOT \n" +
                    "\tThe foot away from one's partner when they stand side by side.\n" +
                    "\n" +
                    "·OUTSIDE HAND \n" +
                    "\tThe hand away from one's partner when they stand side by side.\n" +
                    "\n" +
                    "·OPPOSITE \n" +
                    "\tThe person standing in opposite position across the set.\n" +
                    "\n" +
                    "·PARTNER \n" +
                    "\tGirl to right of Boy and Boy to left of Girl.\n" +
                    "\n" +
                    "·PLACE \n" +
                    "\tTo put the foot (flat) in any desired position without \n" +
                    "\tputting weight on it.\n" +
                    "\n" +
                    "·POINT \n" +
                    "\tTouch toe or ball of free foot on floor and remains there \n" +
                    "\tbriefly.\n" +
                    "\n" +
                    "·PIVOT \n" +
                    "\tTurning on ball, heel, of one or both feet on a fixed place.\n" +
                    "\n" +
                    "·SET \n" +
                    "\tA unit formation of two or more couples.\n" +
                    "\n" +
                    "·SLIDE \n" +
                    "\tTo glide one foot along the floor smoothly, with or no \n" +
                    "\ttransfer of weight.\n" +
                    "\n" +
                    "·STAMP \n" +
                    "\tTo bring down one foot forcibly on the floor with or without \n" +
                    "\ttransfer of weight.\n" +
                    "\n" +
                    "·STEP \n" +
                    "\tWith the weight on one foot, shift the weight into the other \n" +
                    "\tfoot.\n" +
                    "\n" +
                    "·SUPPORTING FOOT \n" +
                    "\tThe foot carrying the weight of the body.\n" +
                    "\n" +
                    "·TAP \n" +
                    "\tToe or ball of free foot is placed momentarily on floor and \n" +
                    "\tlifted again immediately.\n" +
                    "\t\n" +
                    "·TOUCH \n" +
                    "\tSee point.\n" +
                    "\n" +
                    "·WHIRL \n" +
                    "\tTo turn fast by executing small steps in place to right or \n" +
                    "\tLeft.\n" +
                    "ABRASETE  \n" +
                    "\t This term is of Spanish origin. Girl at the right side of Boy, \n" +
                    "\t holds his R arm with her L hand, free hands down at the sides.\n" +
                    "\n" +
                    "·BILAO   \n" +
                    "\t Hands in front, parallel to each other at waist level, elbows \n" +
                    "\t close to the wist, palms down. Reverse the position of the hands \n" +
                    "\t with palms up and down alternatively.\n" +
                    "\n" +
                    "·CABECERAS \n" +
                    "\t The couples (head pairs) occupying the width of the hall in a \n" +
                    "\t square formation. This is of Spanish origin.\n" +
                    "\n" +
                    "·COSTADOS  \n" +
                    "\t The couples (side pairs) occupying the length of the hall in a \n" +
                    "\t square formation. This is of Spanish origin.\n" +
                    "\n" +
                    "·CROSS-OVER \n" +
                    "\t Two couples are opposite each other. Each couple proceeds to\n" +
                    "\t opposite place, the Girls pass by their L shoulders between \n" +
                    "\t the Boys. Boys bow to each other when they meet at the middle, \n" +
                    "\t then follow the Girls to the opposite place. Partners turn right \n" +
                    "\t about upon reaching the opposite place. Girls stand at partners' \n" +
                    "\t right side.\n" +
                    "\n" +
                    "·HAPAY \n" +
                    "\t To flourish or offer a handkerchief, a hat or a glass of wine. \n" +
                    "\t This is a Tagalog dance term.\n" +
                    "\n" +
                    "·HAYON_HAYON \n" +
                    "\t This is a Visayan term meaning to place one forearm in front and \n" +
                    "\t the other behind the waist.\n" +
                    "\n" +
                    "·JALEO \n" +
                    "\t Partners stand with R (L) elbows almost touching. Using walking \n" +
                    "\t or any kind of dance steps they turn once around clockwise \n" +
                    "\t (counter clockwise). This is a Tagalog term of Spanish origin.\n" +
                    "\n" +
                    "·KUMINTANG \n" +
                    "\t Moving the hand from the wrist either clockwise or in counter \n" +
                    "\t clockwise direction. This is an Ilocano dance term.\n" +
                    "\n" +
                    "·MASIWAK \n" +
                    "\t To turn the hand from the wrist half-way clockwise then raise and \n" +
                    "\t lower wrist once or twice. This is an Ibanag dance term.\n" +
                    "\n" +
                    "·PANADYAK \n" +
                    "\t With body weight on L (R) foot, stamp R (L) foot in 4TH. In front, \n" +
                    "\t then tap same foot close to L (R), arms in reverse \"T\" position, \n" +
                    "\t hands doing the \"kumintang\" on the stamp.\n" +
                    "\n" +
                    "·PATAY \n" +
                    "\t To bend the head down so that the forehead touches the R (L) \n" +
                    "\t forearm or the crook of the R (L) elbow while the L (R) hand \n" +
                    "\t supports lightly the palm of the R (L) hand. This is usually \n" +
                    "\t done with the L (R) foot pointing in rear and knees slightly \n" +
                    "         bent.  This is an Ilocano dance term.\n" +
                    "\n" +
                    "·SALOK \n" +
                    "\t To scoop or swing the arm downward upward in front of the body, \n" +
                    "\t the trunk following the movement of the scooping arm. Free hand \n" +
                    "\t in 5th position or holding skirt.  This is a Tagalog term.\n" +
                    "\n" +
                    "·SAROK \n" +
                    "\t Cross the R (L) foot in front of the L (R) foot, bend the body \n" +
                    "\t slightly forward and cross the hand down in front R (L) over \n" +
                    "         L (R). This is a Visayan term.\t\n\n\n\n\n\n");
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 3: TIKLOS") && Objects.equals(term, "PRELIM")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 3");
            content.setText("Tiklos is the Waray equivalent to what is known as “bayanihan” in Tagalog.\n" +
                    "\n" +
                    "Groups of people work for somebody without hoping for anything in return. They work odd jobs like clearing forests, digging the earth for wells, moving a nipa hut to a new location or even building a house — free without charge. Of course grateful benefactors would offer drinks and food; but it is not always expected. The peasants cooperate for the social and economic progress of their community.\n" +
                    "\n" +
                    "\n" +
                    "The tiklos is a native peasant dance of Leyte.\n" +
                    "\n" +
                    "Very early in the morning, the leader of the tiklos beats the tambora, a kind of drum made from a hollow trunk of a tree with a carabao hide head. Next comes sounds of the subing (bamboo flutes) and the guimbal — a small snare drum with a head of a parchment made from the skin of a wildcat.\n" +
                    "\n" +
                    "The peasants come out with grass hooks, bolos and other garden tools and farm implements. Led by the band, they march together to work in the fields. During breaks the peasants enjoy themselves with tuba (a native wine) and the rest dance the tiklos accompanied by the subing (plawta), guimbal and tambora drums or when available, the “sista” played by the band.\n" +
                    "\n" +
                    "The tiklos music is also played to call them back to work." +
                    "See video entitled Tiklos \n\n\n\n\n");
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 4: CARIÑOSA") && Objects.equals(term, "PRELIM")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 4");
            content.setText("A Philippine dance of colonial era origin from the Maria Clara suite of Philippine folk dances, where the fan or handkerchief plays an instrumental role as it places the couple in romance scenario. Originally, the Cariñosa was danced with Maria Clara dress and Barong Tagalog for it is a Maria Clara Spanish Dance when it was introduced. In addition, Filipino wore the patadyong kimona and camisa de chino to reveal nationalism. (a native dress of the Tagalog regions), camisa (a white sleeve) or patadyong kimona (a dress of the Visayan of people) and for boys, a barong Tagalog and colored pants. Because it is the national dance, the dancers may wear any Filipino costumes. See video entitled Cariñosa.\n\n\n\n\n\n");
        } else if (activeLessonOrQuiz.contains("Quiz") && Objects.equals(term, "PRELIM")){
            Intent q = new Intent(getApplicationContext(), Quiz.class);
            q.putExtra("term", term);
            q.putExtra("quizName", activeLessonOrQuiz);
            startActivity(q);
        } else if (activeLessonOrQuiz.contains("Quiz") && Objects.equals(term, "MIDTERM")){
            Intent q = new Intent(getApplicationContext(), Quiz.class);
            q.putExtra("term", term);
            q.putExtra("quizName", activeLessonOrQuiz);
            startActivity(q);
        } else if (activeLessonOrQuiz.contains("Quiz") && Objects.equals(term, "FINALS")){
            Intent q = new Intent(getApplicationContext(), Quiz.class);
            q.putExtra("term", term);
            q.putExtra("quizName", activeLessonOrQuiz);
            startActivity(q);
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 1: CHA CHA CHA") && Objects.equals(term, "MIDTERM")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 1");
            content.setText("The cha-cha-chá, or simply cha-cha in the U.S., is a dance of Cuban origin. The basic footwork pattern of cha-cha-chá (two, three, cha-cha-cha) is also found in several Afro-Cuban dances from the Santería religion. For example, one of the steps used in the dance for the orisha Ogun uses an identical footwork pattern. These Afro-Cuban dances predate the development of cha-cha-chá and were known by many Cubans in the 1950s, especially those of African origin. \nSee video entitled Cha Cha Cha \n\n\n\n\n");
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 2: SWING") && Objects.equals(term, "MIDTERM")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 2");
            content.setText("Swing dance is a group of dances that developed with the swing style of jazz music in the 1920s–1940s, with the origins of each dance predating the popular \"swing era\". Somewhat surprisingly, \"swing dance\" was not commonly used to identify a group of dances until the latter half of the 20th century. Historically, the term \"Swing\" referred to the style of jazz music, which inspired the evolution of the dance. Jitterbug is an umbrella term that denotes all forms of swing dance, though it is often used as a synonym for the six-count derivative of Lindy Hop called \"East Coast Swing\".[4] It was also common to use the word to identify a kind of dancer (i.e., a swing dancer). A \"jitterbug\" might prefer to dance Lindy Hop, Shag, or any of the other swing dances.\n See video entitled Swing \n\n\n\n\n");
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 3: REGGAE") && Objects.equals(term, "MIDTERM")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 3");
            content.setText("Reggae is a music genre that originated in Jamaica in the late 1960s. The term also denotes the modern popular music of Jamaica and its diaspora. A 1968 single by Toots and the Maytals, \"Do the Reggay\" was the first popular song to use the word \"reggae,\" effectively naming the genre and introducing it to a global audience. While sometimes used in a broad sense to refer to most types of popular Jamaican dance music, the term reggae more properly denotes a particular music style that was strongly influenced by traditional mento as well as American jazz and rhythm and blues\n See video entitle Reggae \n\n\n\n\n");
        } else if (Objects.equals(activeLessonOrQuiz, "Lesson 1: LINE DANCE") && Objects.equals(term, "FINALS")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 1");
            content.setText("A line dance is a choreographed dance with a repeated sequence of steps in which a group of people dance in one or more lines or rows, all facing either each other or in the same direction, and executing the steps at the same time. Unlike circle dancing, line dancers are not in physical contact with each other.\n" +
                    "\n" +
                    "Line dancing is a form of dance that takes place with a group of people. Participants line up in rows and execute the same movements in a synchronized manner.\n" +
                    "\n" +
                    "Everyone dances alone, side by side, facing the same direction in lines or rows. .... Each dance consists of a sequence of steps that are repeated throughout the music. Although a variety of music may be used, the major emphasis is on country-and-western music.\n" +
                    "\n" +
                    "Line dancing involves people standing in lines and performing dance movements together. It consists of patterned foot movements that are usually performed to a number of counts per sequence, and then the sequence is repeated. The dances are done one-wall, two-wall, or four-wall.\n See video entitled LA-WALK\n\n\n\n\n");
        }else if (Objects.equals(activeLessonOrQuiz, "Lesson 2: INTERPRETATIVE DANCE") && Objects.equals(term, "FINALS")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 2");
            content.setText("Interpretive dance is a family of modern dance styles that began around 1900 with Isadora Duncan. It used classical concert music but marked a departure from traditional concert dance. It seeks to translate human emotions, conditions, situations or fantasies into movement and dramatic expression, or else adapts traditional ethnic movements into more modern expressions.\n See video entitled Interpretative dance \n\n\n\n\n");
        }else if (Objects.equals(activeLessonOrQuiz, "Lesson 3: HIP HOP") && Objects.equals(term, "FINALS")) {
            title.setText(activeLessonOrQuiz);
            actionBar.setTitle("Lesson 3");
            content.setText("Hip-hop dance refers to street dance styles primarily performed to hip-hop music or that have evolved as part of hip-hop culture. It includes a wide range of styles primarily breaking which was created in the 1970s and made popular by dance crews in the United States. The television show Soul Train and the 1980s films Breakin', Beat Street, and Wild Style showcased these crews and dance styles in their early stages; therefore, giving hip-hop mainstream exposure. The dance industry responded with a commercial, studio-based version of hip-hop—sometimes called \"new style\"—and a hip-hop influenced style of jazz dance called \"jazz-funk\". Classically trained dancers developed these studio styles in order to choreograph from the hip-hop dances that were performed on the street. Because of this development, hip-hop dance is practiced in both dance studios and outdoor spaces.\n" +
                    "\nSee video entitled Hip Hop \n\n\n\n\n");
        }

    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        int action = event.getAction();
        int keyCode = event.getKeyCode();

        switch (keyCode) {

            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    if(txtSize < 36) {
                        txtSize += 2;
                        content.setTextSize(txtSize);
                    }
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    if (txtSize > 8) {
                        txtSize -= 2;
                        content.setTextSize(txtSize);
                    }
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    public void TTS(View view) {
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Toast.makeText(getApplicationContext(), "Feature not supported in you device", Toast.LENGTH_LONG).show();
        } else if (result == TextToSpeech.SUCCESS){
            if (toSpeech.isSpeaking()){
                toSpeech.stop();
            }else {
                text = title.getText().toString() + content.getText().toString();
                toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(toSpeech!=null){
            toSpeech.stop();
            toSpeech.shutdown();
        }
    }

    public void backToLessons (View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
