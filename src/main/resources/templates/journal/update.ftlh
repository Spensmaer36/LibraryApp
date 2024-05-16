<#import "../layout.ftlh" as main>
<@main.layout>
    <form action="/journal/update/${journal.id}" method="post">
        <div class="mb-3">
            <label for="selection1" class="form-label">Choose an book:</label>
            <select id="selection1" name="bookId" class="form-control" id = "bookId">
                <#list books as book>
                    <option value="${book.id}" name="bookId">${book.title}</option>
                </#list>
            </select>
        </div>
        <div class="mb-3">
            <label for="selection2" class="form-label">Choose an reader:</label>
            <select id="selection2" name="readerId" class="form-control" id = "readerId">
                <#list readers as reader>
                    <option value="${reader.id}">${reader.name}</option>
                </#list>
            </select>
        </div>
        <button type="submit" class = "btn btn-primary">Submit</button>
    </form>
</@main.layout>