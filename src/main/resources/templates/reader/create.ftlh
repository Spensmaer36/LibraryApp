<#import "../layout.ftlh" as main>
<@main.layout>
    <form action="/reader/create" method="post" id = "readerForm">
        <div class="mb-3">
            <label for="number" class="form-label">Number</label>
            <input type="text" class="form-control" id="number" name="number">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</@main.layout>