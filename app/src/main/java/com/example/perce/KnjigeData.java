package com.example.perce;

import java.util.ArrayList;

public class KnjigeData {


    public ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
    public static Knjiga izabrana_knjiga = null;

    KnjigeData(){
        knjige.add(new Knjiga(1, "Dvojnici iz tame","Morea Banićević", "2020.", "200", R.drawable.book1,"Morea Banićević, hrvatska autorka čije romane za tinejdžere objavljuje Laguna, ovenčana je nagradom „Ptičica“ u kategoriji za najbolji roman u 2019. „Dvojnici iz tame“, kao i Pohvalu nagrade „Grigor Vitez“ za 2019. za popularizaciju žanra fantastike među mladima za isti roman.Odluku o Nagradi „Ptičica“ donosi Dečji žiri pod pod vođstvom Hrvatskog centra za dečju knjigu pri Knjižnicama grada Zagreba, a ovogodišnji žiri je imao 3 člana i dve članice, dece uzrasta od 11-14 godina. U obrazloženju žirija se navodi zbog čega je roman „Dvojnici iz tame“, dobitnik nagrade:„Vrlo uzbudljiv, napet, uverljiv roman s ritmičnom radnjom i mnogim zapletima. Likovi su jako maštoviti, na primer Mrkljina osobina da voli izmišljati reči i ubacuje ih u govor, ili pak lik sene Abby koja živi samo na svetlu. Osim toga, spisateljica govori o nekim stvarnim problemima i dečjim brigama te kako se oni mogu rešiti. Priča je to o dečjoj družini, prijateljstvu, složnosti i zajedništvu u borbi protiv zlih dvojnika.",
                0 ));
        knjige.add(new Knjiga(2, "Forest Gamp","Vinston Grum", "2017.", "120", R.drawable.book2, "Roman po kojem je snimljen jedan od najboljih filmova svih vremena. Dobro, pa šta? Možda sam idiot, al većinu vremena, u svakom slučaju, pokušavo sam da uradim pravu stvar – a snovi su samo snovi, zar nisu? Pa šta god drugo se desilo, ja kontam ovo: uvek mogu da pogledam unazad i kažem, barem nisam vodio dosadan život. Jel znate šta mislim? Forest Gamp je sa šesnaest godina bio visok metar i devedeset osam santimetara, težio je sto deset kilograma, imao je koeficijent inteligencije 70 i ne baš prijatno detinjstvo. Ali je umeo da trči. I to veoma brzo. A onda ga je otkrio Univerzitet Alabame i od njega stvorio mladu zvezdu američkog fudbala. Tada je počela neverovatna avantura našeg komičnog junaka. Od vijetnamskog heroja do igrača ping-ponga svetskog ranga, od rvača u nameštenim mečevima do uspešnog preduzetnika, naredne tri decenije sudbina je sa Forestom zbijala šale.",
                1));
        knjige.add(new Knjiga(3, "Frede, laku noć", "Dragoslav Mihailović", "2016.", "300", R.drawable.book3, "Oktobarska nagrada grada Beograda. Prva knjiga živog klasika srpske književnosti XX veka, koja je otkrila pisca novog senzibiliteta, originalne forme i jezika, i univerzalnih tema u likovima i doživljajima malih ljudi sa periferije života. Obuhvata antologijske priče „Lilika“, „Boginje“, „Putnik“, „Frede, laku noć“, „Gost“, „Boginje“ i „O tome kako je ostala fleka“. Pisac je ovoj zbirci, po prvi put u ovom izdanju, priključio i priču „Genadije Zadvorski“. „Dobra knjiga mora da vas udari kao pesnica u glavu. Čini mi se da ako ima knjiga kojima ta izreka pristaje, to su knjige Dragoslava Mihailovića, počev od pripovedaka kao što su Lilika, Gost ili Boginje, pa onda romana Kad su cvetale tikve, do ovih koje je pisao poslednjih desetak-petnaest godina. To su knjige koje doživljavate kao snažan, i to sasvim određen potres.“ Ljubiša Jeremić.",
                0));
        knjige.add(new Knjiga(4, "Suze Svetog Nikole", "Branislav Janković", "2021.","250", R.drawable.book4, "Od autora romana O vukovima i senkama. Kad se gresi nagomilaju, put ka iskupljenju postaje neizdrživ… U ratu protiv svojih najvećih strahova, jedan čovek će morati da napiše knjigu plača i hrabrosti. U borbi za njegovu dušu, Sveti Nikola će morati da je pročita. Negde u Srbiji, na međi dva sveta, samuje mesto zvano Studenac. U njega se, nakon plovidbe beskrajnim morima i krvave epopeje Prvog svetskog rata, vraća Gmitar Milošević, u inat košmarima koji ga progone i uprkos predskazanju koje kazuje da će ga tamo sačekati smrt. Baš na 22. maj, letnjeg Svetog Nikolu, iznad Studenca će se otvoriti vrata neke druge stvarnosti i nekog drugog vremena. Ono što će proći kroz njih nateraće i najhrabrije da zadrhte od straha. Od autora romana O vukovima i senkama dolazi priča o grehu i spasenju, zemlji i nebu, anđelima i demonima i svecu čije se ime u Srbiji najviše slavi.",
                1));
        knjige.add(new Knjiga(5, "Kraljevstvo pepela", "Sara Dž. Mas", "2012.", "500", R.drawable.book5, "Sedma knjiga najpopularnijeg tinejdž serijala po oceni Amazona. Nezaboravna epska završnica serijala Stakleni presto. Elin Galatinijus je prvo bila robinja, potom kraljeva krvnica, da bi se na kraju uzdigla do kraljice nekad slavnog kraljevstva. Dok rat izbija širom sveta, njeno putovanje se bliži kraju. Elin je sve stavila na kocku kako bi spasla svoj narod – ali sa stravičnim posledicama po sebe. Pošto ju je kraljica Feja zaključala u gvozdeni sanduk, Elin mora da se osloni na svoju vatrenu volju kako bi istrpela višemesečno mučenje. Svest da će svoje voljene osuditi na propast ako se pokori Mev daje joj snagu, iako je njena rešenost sa svakim danom sve krhkija...",
                0));
        knjige.add(new Knjiga(6,"Luna, vučiji mesec","Ijan Mekdonald", "2020.", "400", R.drawable.book6, "„Mekdonald je jedan od najboljih SF pisaca na svetu. Neustrašiv, briljantan, mudar – u isto vreme vas prosvetljuje i neizmerno zabavlja.“– Kim Stenli Robinson JEDAN OD ZMAJEVA JE MRTAV. Pala je Korta helio, jedna od pet porodičnih korporacija koje vladaju Mesecom. Njena blaga podelili su brojni neprijatelji, a preživeli su se razbežali. Prošlo je osamnaest meseci. Preostala deca senjore Korte, Lukasinjo i Luna, pod zaštitom su moćne porodice Asamoa, dok je Robson, u šoku jer je prisustvovao očevoj nasilnoj smrti, sada štićenik – praktično talac – Makenzi metala. A poslednji naslednik Lukas nestao je s površine Meseca. Samo gospa Sun, udova Taijanga, podozreva da Lukas Korta nije mrtav, i još važnije – da je i dalje jedan od glavnih igrača.",
                1));
        knjige.add(new Knjiga(7, "Životinjska farma", "Džordž Orvel", "2018.", "350", R.drawable.book7, "„Slabi ili jaki, pametni ili priprosti, svi smo mi braća. Nijedna životinja nikad ne sme ubiti neku drugu. Sve životinje su jednake. A sada, drugovi, ispričaću vam šta sam prošle noći sanjao. Ne mogu vam opisati taj san. Bio je to san o tome kako će zemlja izgledati pošto Čovek sa nje iščezne. Ali podsetio me je na nešto što sam odavno već zaboravio. “Povod za nastanak Životinjske farme nalazio se u Orvelovoj analizi posledica Ruske revolucije koja je prerasla u totalitarni režim i diktaturu stvorenu oko kulta ličnosti, kao i u njegovom iskustvu stečenom tokom Španskog građanskog rata. Iako je javnost često insistirala na momentu kritike sovjetske vlasti, Orvel je uvek naglašavao da se Životinjska farma iako prvenstveno satira o Ruskoj revoluciji, odnosi na svaku nasilnu revoluciju koju predvode nemarni ljudi gladni vlasti. „Hteo sam da naravoučenije bude da revolucije donose radikalno poboljšanje samo kada su mase budne i znaju kako da zbace svoje vođe čim ovi obave svoj posao. Trebalo je da prekretnica u priči bude trenutak kada svinje zadrže mleko i jabuke za sebe“, isticao je Orvel razočaran što je čitaocima možda promakao ovaj ključni momenat teksta.",
                0));
        knjige.add(new Knjiga(8, "Odabrane drame", "Bertolt Breht", "2015.", "500", R.drawable.book8, "Ko od rata živi,nek zna Da i sam mora nešto da mu dâ. U komadu Čovek je čovek, paraboli o preobražaju radnika Galija Geja u vojnika, Breht je razvio prve elemente svog epskog pozorišta. Za razliku od tradicionalnog pozorišta koje pruža savršenu iluziju i navodi gledaoca da se poistoveti s likovima komada, Brehtovo epsko pozorište gledaoca želi da podstakne na razmišljanje i politički ga angažuje. Opera za tri groša, koja govori o životu londonskih kriminalaca-biznismena i biznismena-kriminalaca, bila je najuspešniji pozorišni komad u Vajmarskoj republici, dok je komad Majka Hrabrost i njena deca najigranija Brehtova drama do danas. Ova tri dramska teksta temelj su Brehtovog stvaralaštva i najvažniji razlog za uspeh njegovog epskog pozorišta u Nemačkoj, Evropi i svetu. „Brehtov celokupni opus predstavlja Sizifov napor da nekako uskladi sopstvene estetske kriterijume sa nesrećnim dobom u kojem je živeo i čije je zadatke, u očaju, na sebe preuzeo.“ Teodor Adorno.",
                1));
    }
}
