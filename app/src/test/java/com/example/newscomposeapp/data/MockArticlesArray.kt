package com.example.newscomposeapp.data

import com.example.newscomposeapp.data.model.Article
import com.example.newscomposeapp.data.model.Source
import java.util.Date

val articles = listOf(
    Article(
        author = "https://www.facebook.com/bbcnews",
        title = "Israeli strikes on Palestinian Jenin camp in West Bank - BBC",
        description = "A large-scale Israeli military operation is under way in the northern West Bank city of Jenin.",
        url = "https://www.bbc.com/news/world-middle-east-66083295",
        urlToImage = "https://ichef.bbci.co.uk/news/1024/branded_news/E868/production/_130269495_capture.png",
        publishedAt = Date(),
        content = "Media caption, Watch: Tyres set ablaze after Palestinian killed by Israeli air strike\r\nThe Israeli army has launched a massive military operation on the Jenin camp in the north of the occupied West B… [+1669 chars]",
        source = Source(
            id = null,
            name = "BBC News",
        ),
    ),
    Article(
        source = Source(
            id = null,
            name = "KABC-TV",
        ),
        author = null,
        title = "Thousands of SoCal hotel workers officially go on strike after negotiations for higher pay, better benefits fail - KABC-TV",
        description = "Thousands of workers at hotels across Los Angeles County officially walked off the job on Sunday, starting a labor strike as they demand higher wages and better benefits.",
        url = "https://abc7.com/hotel-workers-strike-los-angeles-county-union/13453353/",
        urlToImage = "https://cdn.abcotvs.com/dip/images/13455431_070223-kabc-11pm-hotel-strike-vid.jpg?w=1600",
        publishedAt = Date(),
        content = "LOS ANGELES (KABC) -- Thousands of workers at hotels across Los Angeles County officially walked off the job on Sunday, starting a labor strike as they demand higher wages and better benefits.\r\nThe c… [+3608 chars]",
    ),
    Article(
        source = Source(
            id = null,
            name = "Yahoo Entertainment",
        ),
        author = " Dana Hull and Danny Lee ",
        title = " Tesla, BYD Post Record Sales on Demand for Electric Vehicles -Yahoo Finance ",
        description = "(Bloomberg)-- Tesla Inc.and BYD Co.set sales records in the second quarter, widening their lead as the world ’ s best - selling electric -car makers . Most Read ...",
        url = " https ://finance.yahoo.com/news/tesla-tops-expectations-price-cuts-171703888.html",
        urlToImage = " https ://s.yimg.com/ny/api/res/1.2/YoODzMIGAFkPu55BgNGpgQ--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDA-/https://media.zenfs.com/en/bloomberg_technology_68/2ce81abe271933b32ae508c71920376f",
        publishedAt = Date(),
        content = "(Bloomberg) -- Tesla Inc. and BYD Co. set sales records in the second quarter, widening their lead as the worlds best-selling electric-car makers.\r\nMost Read from Bloomberg\r\nElon Musk-led Tesla deliv… [+3376 chars]",
    ),
    Article(
        source = Source(
            id = null,
            name = "Theregister.com",
        ),
        author = "Simon Sharwood",
        title = "Mars Helicopter phones home after 63 days of silence - The Register",
        description = "If Japanese space boffins have their way, it could be joined by a robotic hummingbird",
        url = "https://www.theregister.com/2023/07/03/ingenuity_mars_helicopter_contact_established/",
        urlToImage = "https://regmedia.co.uk/2020/06/25/ingenuity.jpg",
        publishedAt = Date(),
        content = "NASAs Ingenuity Mars Helicopter has phoned home, more than 60 days after last establishing contact.\r\nIngenuity's last flight was on April 26, when the rotorcraft took to Martian skies for 139 seconds… [+2147 chars]",
    ),
    Article(
        source = Source(
            id = null,
            name = "Cointelegraph",
        ),
        author = "Brayden Lindrea",
        title = "Elon Musk imposes 'rate limit' on Twitter citing extreme ‘system manipulation’ - Cointelegraph",
        description = "Twitter executive chairman Elon Musk has imposed a “rate limit” restriction, as users report outages over the last 24 to 48 hours.",
        url = "https://cointelegraph.com/news/twitter-down-elon-musk-rate-limit-exceeded",
        urlToImage = "https://images.cointelegraph.com/images/1200_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjMtMDcvZTJmOWY0OTctMWNjNi00ZmVjLTg1YzktYmQ5MTkwZTg4MjhjLmpwZw==.jpg",
        publishedAt = Date(),
        content = "Social media platform Twitter is temporarily limiting the number of posts that users will be allowed to read per day, after seeing extreme levels of data scraping and system manipulation, according t… [+2641 chars]",
    ),
    Article(
        source = Source(
            id = null,
            name = "Astrologyzone.com",
        ),
        author = null,
        title =
        "Aries Horoscope for July 2023 - Susan Miller Astrology Zone - Astrology Zone",
        description = "The latest in astrological trends by Susan Miller, comprehensive, complete, intelligent, and accurate. Your life in 3D: culture, style, romance, money, real estate, career advancement, travel, health, fitness, and more.",
        url = "https://www.astrologyzone.com/forecasts/aries-horoscope-for-july-2023/",
        urlToImage = "https://astrologyzone.com/wp-content/uploads/2017/03/02110949/astrologyzone-logo-1088x1088.png",
        publishedAt = Date(),
        content = "This is a really good month, and after having been through a number of high-stress months since April, you will welcome July. July could also serve as a turning point, for your career and home life w… [+2042 chars]",
    ),
    Article(
        source = Source(
            id = "the-washington-post",
            name = "The Washington Post",
        ),
        author = "David J. Lynch",
        title = "Yellen makes first trip to China, seeking stronger ties while supply chains move away - The Washington Post",
        description = "Janet L. Yellen jets to Beijing this week in a test of the administration’s ability to improve relations with China while seeking to cut U.S. companies’ reliance on Chinese factories.",
        url = "https://www.washingtonpost.com/business/2023/07/02/china-yellen-economy/",
        urlToImage = "https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/3NPX6AHGREI6ZJBCCG53SHNTBM_size-normalized.jpg&w=1440",
        publishedAt = Date(),
        content = "Comment on this story\r\nComment\r\nTreasury Secretary Janet L. Yellen jets to Beijing this week in a test of the Biden administrations ability to improve relations with China while pursuing an economic … [+9618 chars]",
    ),
    Article(
        source = Source(
            id = null,
            name = "NBC Chicago",
        ),
        author = "James Neveau",
        title = "Chicago officials reverse flow of river into Lake Michigan to ease flooding from heavy rain - NBC Chicago",
        description = "Officials with the Metropolitan Water Reclamation District of Greater Chicago announced Sunday that they have allowed water from the Chicago River to go into…",
        url = "https://www.nbcchicago.com/weather/chicago-officials-reverse-flow-of-river-into-lake-michigan-to-ease-flooding-from-heavy-rain/3178728/",
        urlToImage = "https://media.nbcchicago.com/2022/04/BODIES-PULLED-FROM-CHICAGO-RIVER.png?resize=1200%2C675&quality=85&strip=all",
        publishedAt = Date(),
        content = "Officials with the Metropolitan Water Reclamation District of Greater Chicago announced Sunday that they have allowed water from the Chicago River to go into Lake Michigan to help alleviate shoreline… [+2169 chars]",
    ),
    Article(
        source = Source(
            id = null,
            name = "KSL.com",
        ),
        author = "https://www.facebook.com/kslcom/",
        title = "July's supermoon will be 14000 miles closer to Earth than a typical full moon event - KSL.com",
        description = "The first of four supermoons to rise in 2023, July's lunar display will appear to be brighter in the night sky than any other full moon event that has occurred this year.",
        url = "https://www.ksl.com/article/50678537/julys-supermoon-will-be-14000-miles-closer-to-earth-than-a-typical-full-moon-event",
        urlToImage = "https://img.ksl.com/slc/2937/293709/29370976.jpg?filter=kslv2/responsive_story_lg",
        publishedAt = Date(),
        content = "Estimated read time: 3-4\r\n minutes\r\nSALT LAKE CITY The first of four supermoons to rise in 2023, July's lunar display will appear to be brighter in the night sky than any other full moon event that h… [+3305 chars]",
    ),
    Article(
        source = Source(
            id = null,
            name = "TMZ",
        ),
        author = "TMZ Staff",
        title = "Taylor Swift's 2011 'Speak Now' Marilyn Monroe Moment from New Angle - TMZ",
        description = "Taylor Swift's 'Marilyn Monroe moment' from 2011 can now be viewed from the front ... some 12 years later.",
        url = "https://www.tmz.com/2023/07/02/taylor-swift-speak-now-marilyn-monroe-moment-new-angle/",
        urlToImage = "https://imagez.tmz.com/image/b9/16by9/2023/07/03/b999aa291ab449da851f6f0f317ab255_xl.png",
        publishedAt = Date(),
        content = "Taylor Swift once had a wardrobe whoopsie eerily similar to Marilyn Monroe's famous blowing-dress moment -- something that, until now, could only be viewed from one side.\r\nDiehard Swifites will likel… [+2071 chars]",
    ),
)
