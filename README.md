# File Explorer API

A REST API built with Spring Boot that scans a file system directory and returns its structure as JSON.

## Features

- Recursive directory scanning
- Option to limit depth
- Structured error responses
- Ignores specified directories (`.git`, `node_modules`, `target`)
- Truncates partially scanned directories

---

## API Endpoint

### Scan Directory

```http
GET /scan
```

### Query Parameters

| Parameter   | Type    | Required | Description |
|------------|---------|----------|-------------|
| `path`      | String  | Yes      | File or directory path to scan |
| `maxDepth`  | Integer | No       | Maximum recursion depth |

---

## Example Requests

### Full Scan

```http
/scan?path=C:/dev
```

### Depth-Limited Scan

```http
/scan?path=C:/dev&maxDepth=1
```

---

## Example Response

```json
{
  "name": "dev",
  "type": "directory",
  "children": [
    {
      "name": "myProject",
      "type": "directory",
      "children": [],
      "truncated": true,
      "skipped": false
    }
  ],
  "truncated": false,
  "skipped": false
}
```

---

## Error Response Example

```json
{
  "message": "Path does not exist",
  "path": "C:/invalid-path",
  "details": "Please provide a valid file or directory path"
}
```

---

## Technologies Used

- Java 17
- Spring Boot
- Maven

---

## Future Improvements

- File type summaries
- File size metadata
- Frontend visualization