<#import "../layout.ftlh" as main>
<@main.layout>
    <form action="/reader/update/${reader.id}" method="post" id = "readerForm">
        <div class="mb-3">
            <label for="name" class="form-label">Number</label>
            <input type="text" class="form-control" id="name" name="number">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Name</label>
            <input type="text" class="form-control" id="description" name="name">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</@main.layout>