
var $step = $("#step");
var $index = $("#index");

$step.step({
    index: 0,
    time: 500,
    title: ["试验流程", "参数配置", "操作结果", "网络状态"]
});

$index.text($step.getIndex());

        $("#prevBtn").on("click", function () {
        $step.prevStep();
    $index.text($step.getIndex());
});

        $("#nextBtn").on("click", function () {
        $step.nextStep();
    $index.text($step.getIndex());
});

        $("#btn1").on("click", function () {
        $step.toStep(1);
    $index.text($step.getIndex());
});

        $("#btn2").on("click", function () {
        $step.toStep(2);
    $index.text($step.getIndex());
});
