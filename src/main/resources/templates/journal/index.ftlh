<#import "../layout.ftlh" as main>
<@main.layout>
<div class="container text-center">
    <div class="center mt-3 mb-3">
        <a type="button" class="btn btn-primary" style="padding: 10px 50px" href="journal/add">Add new record</a>
    </div>
    <div class="row">
        <#list journals as journal>
        <div class="col m-2">
            <div class="card" style="width: 18rem; min-height: 200px">
                <div class="card-header">
                    <h5 class="card-title">Record ${journal.id}</h5>
                </div>
                <div class="card-body">
                    <p class="card-text"> ${books.getBookById(journal.getBookId()).title}</p>
                    <p class="card-text">Reader name: ${readers.getReaderById(journal.readerId).name}</p>
                    <p class="card-text">Reader phone: ${readers.getReaderById(journal.readerId).number}</p>
                </div>
            </div>
        </div>
    </#list>
</div>
</div>
</@main.layout>