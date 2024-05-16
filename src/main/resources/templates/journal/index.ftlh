<#import "../layout.ftlh" as main>
<@main.layout>
<div class="container text-center">
    <div class="row">
        <#list journals as journal>
        <div class="col m-2">
            <div class="card" style="width: 18rem; min-height: 200px">
                <div class="card-header">
                    <h5 class="card-title">Record ${journal.id}</h5>
                </div>
                <div class="card-body">
                    <p class="card-text"> ${books.getBookById(journal.getBookId()).name}</p>
                    <p class="card-text">Reader name: ${readers.getReaderByNumber(journal.phoneNumber).name}</p>
                    <p class="card-text">Reader phone: ${readers.getReaderByNumber(journal.phoneNumber).number}</p>
                </div>
            </div>
        </div>
    </#list>
</div>
</div>
</@main.layout>