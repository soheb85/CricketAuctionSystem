Cricket Auction System

Overview

The Cricket Auction System is a web-based application that facilitates player auctions for cricket teams. It enables team owners to bid for players, manage their budget, and view auction summaries. The system ensures a smooth and transparent auction process.

Features

Player Registration: Add players to the auction system.

Team Management: Register teams and manage their budgets.

Auction Process:

Generate random players for bidding.

Place bids on players.

Mark players as Sold, Unsold, or Pending.

Filtering Players: View all players based on their status (Sold, Unsold, Available).

Auction Summary: Get a summary of all teams and their acquired players.

Technologies Used

Frontend

React.js

Tailwind CSS

Axios (for API calls)

Backend

Spring Boot

Spring Data JPA

PostgreSQL (or MySQL)

Lombok

Setup Instructions

Backend Setup

Clone the repository:

git clone https://github.com/your-repo/cricket-auction.git
cd cricket-auction/backend

Configure database in application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/cricket_auction
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

Run the application:

mvn spring-boot:run

Frontend Setup

Navigate to the frontend folder:

cd ../frontend

Install dependencies:

npm install

Start the React app:

npm run dev

API Endpoints

Team Controller (/team)

Method

Endpoint

Description

POST

/save

Save a new team for the auction.

DELETE

/delete

Delete all teams from the database.

GET

/{id}

Get details of a specific team.

GET

/players

Get all teams along with their players.

Auction Controller (/auction)

Method

Endpoint

Description

GET

/generate

Get a randomly selected player for bidding.

GET

/generate/{id}

Get player details by ID for bidding.

POST

/bid

Place a bid for a player.

POST

/unsold/{id}

Mark a player as unsold.

Players Controller (/player)

Method

Endpoint

Description

POST

/registration

Register a new player for the auction.

DELETE

/delete

Delete all players from the database.

GET

/allPlayer

Get a list of all players with their team name.

Summary Controller (/summary)

Method

Endpoint

Description

GET

/summary

Get the auction summary including all teams and players.

Filtering Players in UI

In the frontend, buttons allow filtering players based on their status:

Show All Players: Displays all players.

Show Sold Players: Displays only sold players.

Show Unsold Players: Displays only unsold players.

Show Available Players: Displays players who are available for auction.

Contribution

Feel free to fork this repository and contribute to improving the system. Create pull requests for feature additions or bug fixes.

License

This project is open-source and available under the MIT License.
