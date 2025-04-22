<h1 align="center" id="title">College API</h1>

<p id="description">API for returning Indian college information</p>

## 📘 Endpoints

### 🔍 `GET /colleges`

Retrieve a list of colleges based on filters.

#### Query Parameters

| Name           | Type     | Description                                 |
|----------------|----------|---------------------------------------------|
| `state`        | `string` | State name (fuzzy match)                    |
| `district`     | `string` | District name (fuzzy match)                 |
| `collegename`  | `string` | College name (fuzzy match)                  |
| `universityname` | `string` | University name (fuzzy match)              |
| `type`         | `string` | College type (fuzzy match ex:affiliated)    |
| `page`         | `integer`| Page number (pagination)                    |
| `size`         | `integer`| Results per page (pagination)               |

#### Response

```json
[
  {
    "id": 1,
    "universityName": "University of Example",
    "collegeName": "Example College",
    "collegeType": "Government",
    "state": "Karnataka",
    "district": "Bangalore"
  }
]
```

---

### 📄 `GET /colleges/{id}`

Retrieve a single college by its ID.

#### Path Parameters

| Name   | Type     | Description             |
|--------|----------|-------------------------|
| `id`   | `integer`| ID of the college        |

#### Response

```json
{
  "id": 1,
  "universityName": "University of Example",
  "collegeName": "Example College",
  "collegeType": "Government",
  "state": "Karnataka",
  "district": "Bangalore"
}
```

<h2>🛠️ Installation Steps:</h2>
<p>1. clone repo</p>

```
git clone http:github.com/yogeshdofficial/collegeapi.
```

<p>3. cd into directory</p>

```
cd collegeapi
```

<p>4. compile the jar</p>

```
./mvnw clean package -DskipTests
```

<p>4. install docker compose and execute</p>

```
docker compose up -d java_app
```

<h2>💻 Built with</h2>

Technologies used in the project:

- postgres
- docker
- spring-boot
- java
