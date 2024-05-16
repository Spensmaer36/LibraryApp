<#import "../layout.ftlh" as main>
<@main.layout>
    <form action="/book/create" method="post" id = "readerForm">
        <div class="mb-3">
            <label for="name" class="form-label">Title of book</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="text" class="form-control" id="description" name="description">
        </div>
        <div class="mb-3">
            <label for="Author" class="form-label">Author</label>
            <input type="text" class="form-control" id="Author" name="author">
        </div>
        <div class="mb-3">
            <label for="release_year" class="form-label">Release year </label>
            <input type="date" class="form-control" id="release_year" name="releaseDate">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</@main.layout>