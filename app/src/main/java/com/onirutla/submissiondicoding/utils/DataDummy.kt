package com.onirutla.submissiondicoding.utils

import com.onirutla.submissiondicoding.R
import com.onirutla.submissiondicoding.data.model.MovieEntity
import com.onirutla.submissiondicoding.data.model.TvEntity

object DataDummy {
    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.apply {
            add(
                MovieEntity(
                    "movie1",
                    "Hustlers",
                    R.drawable.movie_hustlers,
                    "Two exotic dancers (Constance Wu and Jennifer Lopez), both single mothers needing to provide for their families after the 2008 crash, hatch a highly illegal scheme to charm clueless Wall Streeters out of their money. Director Lorene Scafaria’s Hustlers is lively and funny, as well as a reminder that it’s often women—and their children—who suffer most when an economic system driven largely by men collapses. When the going gets tough, the tough … hustle."
                )
            )
            add(
                MovieEntity(
                    "movie2",
                    "A Beautiful Day in the Neighborhood",
                    R.drawable.movie_a_beautiful_day_in_the_neighborhood,
                    "Marielle Heller’s beautifully made film isn’t a biopic of celebrated children’s TV host Fred Rogers. Instead, it shows his ideas in practice, telling the story of an unlikely friendship between Mr. Rogers (Tom Hanks) and a sour journalist (Matthew Rhys) riven with anger issues. Rogers was all about kindness, but Heller’s movie highlights another of his tenets: we have to give ourselves permission to feel everything in order to make peace with the things that threaten to tear us apart."
                )
            )
            add(
                MovieEntity(
                    "movie3",
                    "Dolemite Is My Name",
                    R.drawable.movie_dolemite_is_my_name,
                    "Eddie Murphy stars as Rudy Ray Moore, the real-life performer who financed and starred in an ultra-low-budget 1975 movie—featuring a flashy hustler named Dolemite—that became both a hit and the stuff of legend. Directed by Craig Brewer, this movie is about ambition taking flight against all odds. It’s also pure joy, and as Dolemite himself would tell you, you never kick that out of bed."
                )
            )
            add(
                MovieEntity(
                    "movie4",
                    "Knives Out",
                    R.drawable.movie_knives_out,
                    "Writer-director Rian Johnson’s ensemble whodunit—about a family fighting over the will of an eccentric mystery writer—is so beautifully made that it skims by in a flash. Ana de Armas gives a wonderful performance as the young woman, a nurse who also happens to be an immigrant, at the heart of the intrigue. This gorgeously layered film is great fun to watch, but it’s also perfectly placed in our era. We’re killing one another, but with something that’s the opposite of kindness."
                )
            )
            add(
                MovieEntity(
                    "movie5",
                    "Parasite",
                    R.drawable.movie_parasite,
                    "Korean director Bong Joon Ho’s black comedy–thriller, about an impoverished family who scheme their way into an upper-crust household, artfully explores resentment between the haves and the have-nots. Even more striking is its deep humanity: both the scammers and the scammed earn our sympathy. Parasite is today’s answer to filmmaker Jean Renoir’s famous line, \"“The awful thing about life is this: everyone has their reasons.”\""
                )
            )
            add(
                MovieEntity(
                    "movie6",
                    "Little Women",
                    R.drawable.movie_little_women,
                    "Greta Gerwig’s verdantly alive adaptation of Louisa May Alcott’s evergreen 150-year-old novel—starring Saoirse Ronan as the ambitious and vibrant Jo March—captures the book’s spirit and heart. It also cuts to the reason Alcott’s ideas still resonate: she knew how it felt to yearn for something more, even when you’re not sure what that something more is."
                )
            )
            add(
                MovieEntity(
                    "movie7",
                    "Marriage Story",
                    R.drawable.movie_marriage_story,
                    "Adam Driver and Scarlett Johansson, both astonishing, star as a married couple in the midst of breaking up: To their horror, and ours, their at-first amicable split grows into a monster they had no idea they were capable of creating. This is Noah Baumbach’s most emotionally ragged movie, an acknowledgment that compromises aren’t nuisances that detract from life; they’re the stuff it’s built on."
                )
            )
            add(
                MovieEntity(
                    "movie8",
                    "Once Upon a Time…in Hollywood",
                    R.drawable.movie_once_upon_a_time_in_hollywood,
                    "Quentin Tarantino concocts a fantasy in which Sharon Tate—the actor murdered by Manson family members in 1969—gets the much happier ending she deserves. Margot Robbie plays Tate in a small but potent role; she’s the patron spirit of a late-1960s Hollywood in which a has-been actor (Leonardo DiCaprio) and his stunt double and buddy (Brad Pitt) struggle to find their place. This is Tarantino’s most affectionately detailed picture, filled with tenderness for a lost Hollywood, and a lost era of filmmaking."
                )
            )
            add(
                MovieEntity(
                    "movie9",
                    "The Irishman",
                    R.drawable.movie_the_irishman,
                    "The world doesn’t need another gangster movie, not even one from Martin Scorsese—or so you may have thought before The Irishman. Scorsese’s 3½-hour saga is based on the story of real-life low-level mobster Frank Sheeran (played, superbly, by Robert De Niro), who claims to have killed Jimmy Hoffa (a marvelous Al Pacino), the onetime Teamsters president who disappeared in 1975. For roughly its first two-thirds, The Irishman is hugely entertaining. Then it shifts into something far more complex. It’s a melancholy mob epic."
                )
            )
            add(
                MovieEntity(
                    "movie10",
                    "Pain & Glory",
                    R.drawable.movie_pain_and_glory,
                    "In any life, there’s only so much time to do all we want and need to do. In Pedro Almódovar’s Pain & Glory, Antonio Banderas gives the performance of a lifetime as 60-ish filmmaker Salvador Mallo—a stand-in, more or less, for Almódovar himself—who’s in so much physical pain that he’s uncertain whether he’ll ever work again. Worse yet, his suffering is so intense that he may not care; instead of life after death, he’s settling for death before death, a premature leave-taking that’s a betrayal not just of his gifts, but of the time on earth any of us are given. But an anniversary screening of one of his older films sets off a chain of events that shifts everything: A lost love reappears as if conjured from a dream, and other bits of his past—particularly recollections of his mother, played as a young woman by a radiant Penelope Cruz—reassemble into a joyous, haunting interior monologue that demands to be explored visually, through his art. Pain & Glory may be Almódovar’s most resplendent and moving film, a panorama of vibrant paint-box colors and even more intense emotions—and a hymn to the mysterious whatever-it-is that keeps any of us going, in the years, months or days before our bodies betray us."
                )
            )
        }
        return movies
    }

    fun generateDummyTv(): List<TvEntity> {
        val tvShow = ArrayList<TvEntity>()

        tvShow.apply {
            add(
                TvEntity(
                    "tv1",
                    "When They See Us",
                    R.drawable.tv_when_they_see_us,
                    "Ava DuVernay’s Netflix miniseries When They See Us was unquestionably one of the biggest television events of the year—the famously tight-lipped streaming service announced that it was watched by more than 23 million accounts, and it was nominated for 16 Emmy Awards, eventually winning two. It tells the story of the boys who would be first known as the Central Park Five and then, after spending years in jail for the 1989 rape of a young banker, the Exonerated Five, when the real rapist finally confessed. It’s harrowing and heartbreaking, but a must-watch, especially for Jharrel Jerome’s Emmy-winning performance as Korey Wise"
                )
            )
            add(
                TvEntity(
                    "tv2",
                    "BoJack Horseman",
                    R.drawable.tv_bojack_horseman,
                    "In BoJack Horseman’s standout sixth and final season, we pick up right where the previous season left off: with everyone’s favorite equine sitcom star checking into seaside rehab, determined to kick his alcoholism and mend fences with the loved ones he wronged. What follows is a singular season where the typically inward-facing show turns outward, widening the lens to ask what we owe one another. Though the characters are mostly isolated from one another, set forward on propulsive paths of individual growth, their journeys make for a thematically cohesive story. Together they ask how we can get our heads out of our own asses—how we can build lives of accountability and service to others. To see these characters consider a more selfless, outward-facing way through life is to see them grow monumentally, and to see the show move toward an ending that feels leagues away from where it started"
                )
            )
            add(
                TvEntity(
                    "tv3",
                    "Euphoria",
                    R.drawable.tv_euphoria,
                    "Before HBO’s Euphoria—which follows a group of Gen-Zers in a no-named, vaguely tropical teenage romper-room-world—found its voice as a funny-but-trippy, heartfelt-but-brutal look at relationships and growing up, it was a pretty labor-intensive watch. You can’t exactly follow ketamine-dripping teens and rogue locker room dicks for more than an hour at a time. But after a couple episodes, Euphoria stopped trying to shock the olds, and instead focused on its protagonist, Rue—played by a brilliant Zendaya. This gave us these inventive, surreal moments—like an ingenious spin on Rue’s manic-depressive episode as an old-school detective thriller (“I’m Morgan fuckin’ Freeman and this is the beginning of the third act”), or the dick pic seminar to end all dick pic seminars. The result? The best look at the generation born after 9/11 we’ve seen on TV yet"
                )
            )
            add(
                TvEntity(
                    "tv4",
                    "Mindhunter",
                    R.drawable.tv_mindhunter,
                    "Save for playing into our current true-crime-obsessed culture, it’s a little bit of a surprise that Netflix’s Mindhunter became the hit it did. It’s everything that blink-and-you’ll-miss-it streaming binges aren’t: Often slow, plodding, think-y, takes time to kick back and smell the cigarette smoke. But it’s the creeping pace that makes Mindhunter, which follows the FBI’s Behavioral Science Unit as they interview serial killers around the country, so damn engrossing. David Fincher’s big TV splash—which features an incredible (but never-not-anxious) Jonathan Groff as special agent Holden Ford—if anything, only improved in Season Two, where we finally met one of the big bads, Charles Manson"
                )
            )
            add(
                TvEntity(
                    "tv5",
                    "Chernobyl",
                    R.drawable.tv_chernobyl,
                    "This joint BBC and HBO production isn’t just one of the best TV show’s of 2019, it’s potentially one of the best TV shows ever. It’s IMDb’s top-rated series of all time, and cleaned up at the Emmys with 10 wins and 19 nominations. The true story of the 1986 disaster at the Chernobyl Nuclear Power Plant created life in 1980s Soviet Union to painstaking detail, all to demonstrate (with at times stomach-churningly realistic gore) the ways in which one local accident became a global disaster."
                )
            )
            add(
                TvEntity(
                    "tv6",
                    "Jane the Virgin",
                    R.drawable.tv_jane_the_virgin,
                    "If you’re in the market for a show that’s smart, infectiously warm, and just plain fun, Jane the Virgin is that show. Based on a Venezuelan telenovela, Jane is a love letter to the form, with a very telenovela premise. 23-year-old Jane Villaneuva is a teacher and aspiring writer waitressing at a hotel restaurant to make ends meet, but her hyper-planned life is thrown off track when her gynecologist accidentally inseminates her at a routine check-up. To complicate matters, Jane becomes pregnant without ever experiencing sex, as she’s saving herself for marriage to her police officer fiance—and the sperm donor is her married boss, with whom she once shared a torrid, fleeting kiss. In an age when prestige TV too often means moody, navel-gazing drama, Jane the Virgin proves that excellent television needn’t be dark, self-serious, or humorless. In fact, it can be an explosion of whimsy, pure delight, and kisses that literally lift your feet off the ground. Jane herself describes the story best: “a big, multigenerational story with romance, and drama, and heartache, and crime, even—all of the lightness and all of the darkness"
                )
            )
            add(
                TvEntity(
                    "tv7",
                    "The Mandalorian",
                    R.drawable.tv_the_mandalorian,
                    "The whole internet loves Baby Yoda. Even if they haven't seen a single episode of Disney+'s The Mandalorian, they know about the little, green 50-year-old child. They've seen him drink his broth, they've seen him coo in his little crib. Sure, he's the star, but somehow his adorableness doesn't overshadow what's a truly impressive, and beautifully made Star Wars series. While sometimes the story can be rather formulaic, The Mandalorian does exactly what it needs to do: Engross viewers in the gritty side of Star Wars, placing them in the planets and towns and stories that the films just don't have the time to expand upon"
                )
            )
            add(
                TvEntity(
                    "tv8",
                    "Watchmen",
                    R.drawable.tv_watchmen,
                    "Alan Moore and Dave Gibbons's Watchmen comics revolutionized the medium. The transgressive series upended our idea of superhero stories and has been debated by fans and scholars since its first publication in the mid-'80s. To continue this beloved, challenging series as an HBO series is a daunting task. Yet, Damon Lindelof pulled off the impossible—creating a show that's not a carbon copy, but channels the punk rock spirit of the original source material. With incredible acting from leads like Regina King and Jean Smart, this is the series that fans deserve, even if they didn't know it was the one they wanted"
                )
            )
            add(
                TvEntity(
                    "tv9",
                    "Succession",
                    R.drawable.tv_succession,
                    "In its second season, Succession continued the Shakespearean story of the Roy family—one that's hilarious and emotional as it is prescient. Touching on everything from politics to media, the inner workings of the billionaires with a vice-grip on our country, Succession makes our real-life villains into tragic, human figures. Superbly acted and brilliantly written, Succession is shaping up to be one of the most important dramas of the next decade."
                )
            )
            add(
                TvEntity(
                    "tv10",
                    "Big Mouth",
                    R.drawable.tv_big_mouth,
                    "Nick Kroll’s animated creation is as good (if not better) in Season Three than it has ever been before. Mixing humor with incredibly difficult topics (#MeToo, gaslighting, homophobia, racism), Big Mouth never crosses into preachy territory. Yet somehow, the series manages to tell a story of being a teenager more effectively than anyone else on television right now. If you’re going to watch a single episode of this season, “Disclosure the Movie: The Musical” is the most ridiculous, hilarious offering of the bunch. — Justin Kirkland"
                )
            )
        }
        return tvShow
    }
}