package com.paul.mobilelearning;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Objects;

public class Quiz extends AppCompatActivity {

    TextView question1,question2,question3,question4,question5,
             question6,question7,question8,question9,question10,
             result, score;
    RadioGroup choices1,choices2,choices3,choices4,choices5,
               choices6,choices7,choices8,choices9,choices10;
    RadioButton r1a,r2a,r3a,r4a,r5a,r6a,r7a,r8a,r9a,r10a,
                r1b,r2b,r3b,r4b,r5b,r6b,r7b,r8b,r9b,r10b,
                r1c,r2c,r3c,r4c,r5c,r6c,r7c,r8c,r9c,r10c,
                r1d,r2d,r3d,r4d,r5d,r6d,r7d,r8d,r9d,r10d;
    Button checkAnswer;
    TextView[] answers;
    String activeQuiz;

    int totalScore, txtSize = 14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent i = getIntent();
        activeQuiz = i.getStringExtra("quizName");
        String term = i.getStringExtra("term");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(activeQuiz);

        TextView[] questions = {
                (TextView) findViewById(R.id.question1),(TextView) findViewById(R.id.question2),
                (TextView) findViewById(R.id.question3),(TextView) findViewById(R.id.question4),
                (TextView) findViewById(R.id.question5),(TextView) findViewById(R.id.question6),
                (TextView) findViewById(R.id.question7),(TextView) findViewById(R.id.question8),
                (TextView) findViewById(R.id.question9),(TextView) findViewById(R.id.question10)
        };

        RadioGroup[] choices = {
                (RadioGroup) findViewById(R.id.choices1),(RadioGroup) findViewById(R.id.choices2),
                (RadioGroup) findViewById(R.id.choices3),(RadioGroup) findViewById(R.id.choices4),
                (RadioGroup) findViewById(R.id.choices5),(RadioGroup) findViewById(R.id.choices6),
                (RadioGroup) findViewById(R.id.choices7),(RadioGroup) findViewById(R.id.choices8),
                (RadioGroup) findViewById(R.id.choices10),(RadioGroup) findViewById(R.id.choices10)
        };

        r1a  = (RadioButton) findViewById(R.id.radioButton1a);
        r2a = (RadioButton) findViewById(R.id.radioButton2a);
        r3a = (RadioButton) findViewById(R.id.radioButton3a);
        r4a = (RadioButton) findViewById(R.id.radioButton4a);
        r5a = (RadioButton) findViewById(R.id.radioButton5a);
        r6a = (RadioButton) findViewById(R.id.radioButton6a);
        r7a = (RadioButton) findViewById(R.id.radioButton7a);
        r8a = (RadioButton) findViewById(R.id.radioButton8a);
        r9a = (RadioButton) findViewById(R.id.radioButton9a);
        r10a = (RadioButton) findViewById(R.id.radioButton10a);
        r1b = (RadioButton) findViewById(R.id.radioButton1b);
        r2b = (RadioButton) findViewById(R.id.radioButton2b);
        r3b = (RadioButton) findViewById(R.id.radioButton3b);
        r4b = (RadioButton) findViewById(R.id.radioButton4b);
        r5b = (RadioButton) findViewById(R.id.radioButton5b);
        r6b = (RadioButton) findViewById(R.id.radioButton6b);
        r7b = (RadioButton) findViewById(R.id.radioButton7b);
        r8b = (RadioButton) findViewById(R.id.radioButton8b);
        r9b = (RadioButton) findViewById(R.id.radioButton9b);
        r10b = (RadioButton) findViewById(R.id.radioButton10b);
        r1c = (RadioButton) findViewById(R.id.radioButton1c);
        r2c = (RadioButton) findViewById(R.id.radioButton2c);
        r3c = (RadioButton) findViewById(R.id.radioButton3c);
        r4c = (RadioButton) findViewById(R.id.radioButton4c);
        r5c = (RadioButton) findViewById(R.id.radioButton5c);
        r6c = (RadioButton) findViewById(R.id.radioButton6c);
        r7c = (RadioButton) findViewById(R.id.radioButton7c);
        r8c = (RadioButton) findViewById(R.id.radioButton8c);
        r9c = (RadioButton) findViewById(R.id.radioButton9c);
        r10c = (RadioButton) findViewById(R.id.radioButton10c);
        r1d = (RadioButton) findViewById(R.id.radioButton1d);
        r2d = (RadioButton) findViewById(R.id.radioButton2d);
        r3d = (RadioButton) findViewById(R.id.radioButton3d);
        r4d = (RadioButton) findViewById(R.id.radioButton4d);
        r5d = (RadioButton) findViewById(R.id.radioButton5d);
        r6d = (RadioButton) findViewById(R.id.radioButton6d);
        r7d = (RadioButton) findViewById(R.id.radioButton7d);
        r8d = (RadioButton) findViewById(R.id.radioButton8d);
        r9d = (RadioButton) findViewById(R.id.radioButton9d);
        r10d = (RadioButton) findViewById(R.id.radioButton10d);

        checkAnswer = (Button) findViewById(R.id.checkAnswer);


        if (Objects.equals(activeQuiz, "Prelim Quiz") && Objects.equals(term, "PRELIM")){
            answers = displayPrelimQuiz();
        } else if (Objects.equals(activeQuiz, "Midterm Quiz") && Objects.equals(term, "MIDTERM")){
            answers = displayMidtermQuiz();
        } else if (Objects.equals(activeQuiz, "Finals Quiz")&& Objects.equals(term, "FINALS")){
            answers = displayFinalsQuiz();
        }
    }

    @SuppressLint("ResourceAsColor")
    public void onCheck(View[] correctAnswer){

        RadioGroup[] choices = new RadioGroup[]{
                (RadioGroup) findViewById(R.id.choices1),(RadioGroup) findViewById(R.id.choices2),
                (RadioGroup) findViewById(R.id.choices3),(RadioGroup) findViewById(R.id.choices4),
                (RadioGroup) findViewById(R.id.choices5),(RadioGroup) findViewById(R.id.choices6),
                (RadioGroup) findViewById(R.id.choices7),(RadioGroup) findViewById(R.id.choices8),
                (RadioGroup) findViewById(R.id.choices9),(RadioGroup) findViewById(R.id.choices10)
        };

        for (int ctr=0; ctr<10; ctr++){
            int selectedId = choices[ctr].getCheckedRadioButtonId();
            if (selectedId == correctAnswer[ctr].getId()){
                totalScore++;
            }
        }
    }

    public TextView[] displayPrelimQuiz(){

        //Edit questions here
        String[] questionsStr = {
                "1. Arms opened sideward, raised below shoulder level with a graceful curve. What position is this?",
                "2. The foot not supporting the weight of the body",
                "3. An Ilocano dance term",
                "4. Waray equivalent to what is known as \"bayanihan\" in Tagalog",
                "5. a Philippine dance of colonial era origin from the Maria Clara suite of Philippine folk dances",
                "6.  To scoop or swing the arm downward upward in front of the body,  the trunk following the movement of the scooping arm. Free hand  in 5th position or holding skirt. ",
                "7. A unit formation of two or more couples. ",
                "8. Partners bow to each other to opposite dancers or to the audience ",
                "9. The hand not doing anything. ",
                "10. Spring from one or two feet and land on both feet.",
        };
        //Edit choices per number
        String[] choices1 = {
                "A. Second Position",
                "B. Third Position",
                "C. First Position",
                "D. Fifth Position"
        };
        String[] choices2 = {
                "A. Hop", "B. Free Foot", "C. Jump", "D. Inside foot"
        };
        String[] choices3 = {
                "A. Masiwak","B. Panadyak","C. Kumintang","D. Panipa "
        };
        String[] choices4 = {
                "A. Siklot ","B. Tiklos","C. Tilsok","D. Siltok"

        };
        String[] choices5 = {
                "A. Maria Clara","B. Tinikling","C. Hiphop","D.Cariñosa"
        };
        String[] choices6 = {
                "A. PATAY ","B. TIKLOS","C. SALOK","D. IGIB"

        };
        String[] choices7 = {
                "A. SET","B. PART","C. GROUP","D. PAIR"
        };
        String[] choices8 = {
                "A. GENUFLECT","B. SALUDO","C. MANO","D. SAMBA"
        };
        String[] choices9 = {
                "A. HANDS FREE","B. JAZZ HANDS","C. FREE HAND","D. HANDS DOWN"
        };
        String[] choices10 = {
                "A. LEAP ","B. HOP","C. BOUNCE","D. JUMP"
        };

        //Edit correct answer
        TextView[] correctAnswers = {
                r1a,
                r2b,
                r3c,
                r4b,
                r5d,
                r6c,
                r7a,
                r8b,
                r9c,
                r10d
        };

        TextView[] questions = {
                (TextView) findViewById(R.id.question1),(TextView) findViewById(R.id.question2),
                (TextView) findViewById(R.id.question3),(TextView) findViewById(R.id.question4),
                (TextView) findViewById(R.id.question5),(TextView) findViewById(R.id.question6),
                (TextView) findViewById(R.id.question7),(TextView) findViewById(R.id.question8),
                (TextView) findViewById(R.id.question9),(TextView) findViewById(R.id.question10)
        };

        RadioButton[] c1 = {r1a, r1b,r1c,r1d};
        RadioButton[] c2 = {r2a, r2b,r2c,r2d};
        RadioButton[] c3 = {r3a, r3b,r3c,r3d};
        RadioButton[] c4 = {r4a, r4b,r4c,r4d};
        RadioButton[] c5 = {r5a, r5b,r5c,r5d};
        RadioButton[] c6 = {r6a, r6b,r6c,r6d};
        RadioButton[] c7 = {r7a, r7b,r7c,r7d};
        RadioButton[] c8 = {r8a, r8b,r8c,r8d};
        RadioButton[] c9 = {r9a, r9b,r9c,r9d};
        RadioButton[] c10 = {r10a, r10b,r10c,r10d};


        for (int ctr=0; ctr<10; ctr++){
            questions[ctr].setText(questionsStr[ctr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c1[cCtr].setText(choices1[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c2[cCtr].setText(choices2[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c3[cCtr].setText(choices3[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c4[cCtr].setText(choices4[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c5[cCtr].setText(choices5[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c6[cCtr].setText(choices6[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c7[cCtr].setText(choices7[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c8[cCtr].setText(choices8[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c9[cCtr].setText(choices9[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c10[cCtr].setText(choices10[cCtr]);
        }
        //onNext(nextQuestion, questions[0],aChoices[0],bChoices[0],cChoices[0],dChoices[0],correctAnswers[0]);
        //display totalScore
        //Log.i("total score", String.valueOf(totalScore));
        return correctAnswers;
    }

    public TextView[] displayMidtermQuiz(){

        String[] questionsStr = {
                "1. A dance of Cuban origin ",
                "2. A dance that was developed with the Jazz",
                "3. a particular music style that was strongly influenced by traditional mento as well as American jazz ",
                "4. An umbrella term that denotes all forms of swing dance",
                "5. Originally, the Cariñosa was danced with ",
                "6. Cha Cha Cha is best danced in",
                "7. To turn fast by executing small steps in place to right or Left ",
                "8.  Cross the R (L) foot in front of the L (R) foot, bend the body slightly forward and cross the hand down in front R (L) over  L (R). This is a Visayan term.	",
                "9. To turn the hand from the wrist half-way clockwise then raise and  lower wrist once or twice. This is an Ibanag dance term.",
                "10. To flourish or offer a handkerchief, a hat or a glass of wine. "

        };
        String[] choices1 = {
                "A. Cha Cha Cha ",
"B. Salsa",
"C. Cariñosa",
"D. El Cubano Arisa"

        };
        String[] choices2 = {
               "A. SWING",
"B. TWIST",
"C. CHACHA",
"D. BALLET"


        };
        String[] choices3 = {
                "A. RHASTA",
"B. REGGAE",
"C. REGGIE",
"D. ROGUE"

        };
        String[] choices4 = {
           "A. Pittsburgh ",
"B. Jitterbug",
"C. Ladyburg",
"D. Pittsbug"

        };
        String[] choices5 = {
              "A. Maria Clara dress and Barong Tagalog",
"B. Maong and Loose Dress",
"C. Cocktail Dress",
"D. Maria Clara pants"

        };
        String[] choices6 = {
                "A. solo",
"B. pairs",
"C. threesomes",
"D. group"

        };
        String[] choices7 = {
               "A. Hop",
"B. Twirl",
"C. Whirl",
"D. Hurl"

        };
        String[] choices8 = {
               "A. Sarok",
"B. Salok",
"C. Talok",
"D. Tarok"

        };
        String[] choices9 = {
              "A. Masiwak ",
"B. Panadyak",
"C. Talaktak",
"D. Kasawak"

        };
        String[] choices10 = {
                "A. Tapay",
"B. Hapay",
"C. Patay",
"D. Kapay"

        };

        TextView[] correctAnswers = {
                r1a,
                r2a,
                r3b,
                r4a,
                r5a,
                r6b,
                r7c,
                r8a,
                r9a,
                r10b
        };

        TextView[] questions = {
                (TextView) findViewById(R.id.question1),(TextView) findViewById(R.id.question2),
                (TextView) findViewById(R.id.question3),(TextView) findViewById(R.id.question4),
                (TextView) findViewById(R.id.question5),(TextView) findViewById(R.id.question6),
                (TextView) findViewById(R.id.question7),(TextView) findViewById(R.id.question8),
                (TextView) findViewById(R.id.question9),(TextView) findViewById(R.id.question10)
        };

        RadioButton[] c1 = {r1a, r1b,r1c,r1d};
        RadioButton[] c2 = {r2a, r2b,r2c,r2d};
        RadioButton[] c3 = {r3a, r3b,r3c,r3d};
        RadioButton[] c4 = {r4a, r4b,r4c,r4d};
        RadioButton[] c5 = {r5a, r5b,r5c,r5d};
        RadioButton[] c6 = {r6a, r6b,r6c,r6d};
        RadioButton[] c7 = {r7a, r7b,r7c,r7d};
        RadioButton[] c8 = {r8a, r8b,r8c,r8d};
        RadioButton[] c9 = {r9a, r9b,r9c,r9d};
        RadioButton[] c10 = {r10a, r10b,r10c,r10d};


        for (int ctr=0; ctr<10; ctr++){
            questions[ctr].setText(questionsStr[ctr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c1[cCtr].setText(choices1[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c2[cCtr].setText(choices2[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c3[cCtr].setText(choices3[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c4[cCtr].setText(choices4[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c5[cCtr].setText(choices5[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c6[cCtr].setText(choices6[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c7[cCtr].setText(choices7[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c8[cCtr].setText(choices8[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c9[cCtr].setText(choices9[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c10[cCtr].setText(choices10[cCtr]);
        }
        //onNext(nextQuestion, questions[0],aChoices[0],bChoices[0],cChoices[0],dChoices[0],correctAnswers[0]);
        //display totalScore
        //Log.i("total score", String.valueOf(totalScore));
        return correctAnswers;
    }

    public TextView[] displayFinalsQuiz(){

        String[] questionsStr = {
                "1. A choreographed dance with a repeated sequence of steps in which a group of people dance in one or more lines or rows ",
"2. Uses classical concert music but marked a departure from traditional concert dance. It seeks to translate human emotions, conditions, situations or fantasies into movement and dramatic expression",
"3. To scoop or swing the arm downward upward in front of the body,  the trunk following the movement of the scooping arm. Free hand  in 5th position or holding skirt.  ",
"4.  It includes a wide range of styles primarily breaking which was created in the 1970s and made popular by dance crews in the United States.",
"5. The dances are done one-wall, two-wall, or four-wall.",
"6. There are how many hand fundamental position in folk dance? ",
"7. This is a Visayan term meaning to place one forearm in front and the other behind the waist.",
"8. The couples (side pairs) occupying the length of the hall in a square formation. This is of Spanish origin.",
"9. Touch toe or ball of free foot on floor and remains there briefly. ",
"10. Same as point "

        };
        String[] choices1 = {
               "A. Row dance ",
"B. Line dance",
"C. Group Dance",
"D. Cheerdance"

        };
        String[] choices2 = {
                "A. Line Dance",
"B. Sad Dance",
"C. Interpretative Dance",
"D. HipHop"

        };
        String[] choices3 = {
               "A. Salok ",
"B. Tarok",
"C. Sarok",
"D. Barok"

        };
        String[] choices4 = {
                "A. Line Dance",
"B. Interpretative Dance",
"C. HopStep",
"D. HipHop "

        };
        String[] choices5 = {
               "A. Jazz",
"B. Interpretative",
"C. HipHop",
"D. Line Dance"

        };
        String[] choices6 = {
                "A.  5 ",
"B.  6 ",
"C.  4 ",
"D.  3 "

        };
        String[] choices7 = {
                "A. Kuyog Kuyog",
"B. Dayon Dayon",
"C. Hayon Hayon",
"D. Tayon Tayon"

        };
        String[] choices8 = {
                "A. Costados",
"B. Bostados",
"C. Bastardos",
"D. Jilados"

        };
        String[] choices9 = {
                "A. Repoint ",
"B. Point",
"C. Joint",
"D. Step"

        };
        String[] choices10 = {
               "A. Touch",
"B. Reach",
"C. Hault",
"D. Stepback"

        };

        TextView[] correctAnswers = {
                r1b,
                r2c,
                r3a,
                r4d,
                r5d,
                r6a,
                r7c,
                r8a,
                r9b,
                r10a
        };

        TextView[] questions = {
                (TextView) findViewById(R.id.question1),(TextView) findViewById(R.id.question2),
                (TextView) findViewById(R.id.question3),(TextView) findViewById(R.id.question4),
                (TextView) findViewById(R.id.question5),(TextView) findViewById(R.id.question6),
                (TextView) findViewById(R.id.question7),(TextView) findViewById(R.id.question8),
                (TextView) findViewById(R.id.question9),(TextView) findViewById(R.id.question10)
        };

        RadioButton[] c1 = {r1a, r1b,r1c,r1d};
        RadioButton[] c2 = {r2a, r2b,r2c,r2d};
        RadioButton[] c3 = {r3a, r3b,r3c,r3d};
        RadioButton[] c4 = {r4a, r4b,r4c,r4d};
        RadioButton[] c5 = {r5a, r5b,r5c,r5d};
        RadioButton[] c6 = {r6a, r6b,r6c,r6d};
        RadioButton[] c7 = {r7a, r7b,r7c,r7d};
        RadioButton[] c8 = {r8a, r8b,r8c,r8d};
        RadioButton[] c9 = {r9a, r9b,r9c,r9d};
        RadioButton[] c10 = {r10a, r10b,r10c,r10d};


        for (int ctr=0; ctr<10; ctr++){
            questions[ctr].setText(questionsStr[ctr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c1[cCtr].setText(choices1[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c2[cCtr].setText(choices2[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c3[cCtr].setText(choices3[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c4[cCtr].setText(choices4[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c5[cCtr].setText(choices5[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c6[cCtr].setText(choices6[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c7[cCtr].setText(choices7[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c8[cCtr].setText(choices8[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c9[cCtr].setText(choices9[cCtr]);
        }
        for(int cCtr=0; cCtr<4; cCtr++) {
            c10[cCtr].setText(choices10[cCtr]);
        }
        //onNext(nextQuestion, questions[0],aChoices[0],bChoices[0],cChoices[0],dChoices[0],correctAnswers[0]);
        //display totalScore
        //Log.i("total score", String.valueOf(totalScore));
        return correctAnswers;
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        TextView q1 = (TextView) findViewById(R.id.question1);
        TextView q2 = (TextView) findViewById(R.id.question2);
        TextView q3 = (TextView) findViewById(R.id.question3);
        TextView q4 = (TextView) findViewById(R.id.question4) ;
        TextView q5 = (TextView) findViewById(R.id.question5);
        TextView q6 = (TextView) findViewById(R.id.question6);
        TextView q7 = (TextView) findViewById(R.id.question7);
        TextView q8 = (TextView) findViewById(R.id.question8);
        TextView q9 = (TextView) findViewById(R.id.question9);
        TextView q10 = (TextView) findViewById(R.id.question10);

        switch (keyCode) {

            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    if(txtSize < 36) {
                        txtSize += 2;
                        q1.setTextSize(txtSize);
                        q2.setTextSize(txtSize);
                        q3.setTextSize(txtSize);
                        q4.setTextSize(txtSize);
                        q5.setTextSize(txtSize);
                        q6.setTextSize(txtSize);
                        q7.setTextSize(txtSize);
                        q8.setTextSize(txtSize);
                        q9.setTextSize(txtSize);
                        q10.setTextSize(txtSize);
                        r1a.setTextSize(txtSize);
                        r2a.setTextSize(txtSize);
                        r3a.setTextSize(txtSize);
                        r4a.setTextSize(txtSize);
                        r5a.setTextSize(txtSize);
                        r6a.setTextSize(txtSize);
                        r7a.setTextSize(txtSize);
                        r8a.setTextSize(txtSize);
                        r9a.setTextSize(txtSize);
                        r10a.setTextSize(txtSize);
                        r1b.setTextSize(txtSize);
                        r2b.setTextSize(txtSize);
                        r3b.setTextSize(txtSize);
                        r4b.setTextSize(txtSize);
                        r5b.setTextSize(txtSize);
                        r6b.setTextSize(txtSize);
                        r7b.setTextSize(txtSize);
                        r8b.setTextSize(txtSize);
                        r9b.setTextSize(txtSize);
                        r10b.setTextSize(txtSize);
                        r1c.setTextSize(txtSize);
                        r2c.setTextSize(txtSize);
                        r3c.setTextSize(txtSize);
                        r4c.setTextSize(txtSize);
                        r5c.setTextSize(txtSize);
                        r6c.setTextSize(txtSize);
                        r7c.setTextSize(txtSize);
                        r8c.setTextSize(txtSize);
                        r9c.setTextSize(txtSize);
                        r10c.setTextSize(txtSize);
                        r1d.setTextSize(txtSize);
                        r2d.setTextSize(txtSize);
                        r3d.setTextSize(txtSize);
                        r4d.setTextSize(txtSize);
                        r5d.setTextSize(txtSize);
                        r6d.setTextSize(txtSize);
                        r7d.setTextSize(txtSize);
                        r8d.setTextSize(txtSize);
                        r9d.setTextSize(txtSize);
                        r10d.setTextSize(txtSize);
                    }
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    if (txtSize > 8) {
                        txtSize -= 2;
                        q1.setTextSize(txtSize);
                        q2.setTextSize(txtSize);
                        q3.setTextSize(txtSize);
                        q4.setTextSize(txtSize);
                        q5.setTextSize(txtSize);
                        q6.setTextSize(txtSize);
                        q7.setTextSize(txtSize);
                        q8.setTextSize(txtSize);
                        q9.setTextSize(txtSize);
                        q10.setTextSize(txtSize);
                        r1a.setTextSize(txtSize);
                        r2a.setTextSize(txtSize);
                        r3a.setTextSize(txtSize);
                        r4a.setTextSize(txtSize);
                        r5a.setTextSize(txtSize);
                        r6a.setTextSize(txtSize);
                        r7a.setTextSize(txtSize);
                        r8a.setTextSize(txtSize);
                        r9a.setTextSize(txtSize);
                        r10a.setTextSize(txtSize);
                        r1b.setTextSize(txtSize);
                        r2b.setTextSize(txtSize);
                        r3b.setTextSize(txtSize);
                        r4b.setTextSize(txtSize);
                        r5b.setTextSize(txtSize);
                        r6b.setTextSize(txtSize);
                        r7b.setTextSize(txtSize);
                        r8b.setTextSize(txtSize);
                        r9b.setTextSize(txtSize);
                        r10b.setTextSize(txtSize);
                        r1c.setTextSize(txtSize);
                        r2c.setTextSize(txtSize);
                        r3c.setTextSize(txtSize);
                        r4c.setTextSize(txtSize);
                        r5c.setTextSize(txtSize);
                        r6c.setTextSize(txtSize);
                        r7c.setTextSize(txtSize);
                        r8c.setTextSize(txtSize);
                        r9c.setTextSize(txtSize);
                        r10c.setTextSize(txtSize);
                        r1d.setTextSize(txtSize);
                        r2d.setTextSize(txtSize);
                        r3d.setTextSize(txtSize);
                        r4d.setTextSize(txtSize);
                        r5d.setTextSize(txtSize);
                        r6d.setTextSize(txtSize);
                        r7d.setTextSize(txtSize);
                        r8d.setTextSize(txtSize);
                        r9d.setTextSize(txtSize);
                        r10d.setTextSize(txtSize);
                    }
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    public void displayResult(View view) {
        onCheck(answers);
        Log.i("SCORE", String.valueOf(totalScore));

        Intent goToQuizResult = new Intent(getApplicationContext(), QuizResult.class);
        goToQuizResult.putExtra("score", String.valueOf(totalScore));
        goToQuizResult.putExtra("quizName", activeQuiz);
        startActivity(goToQuizResult);
    }
}
