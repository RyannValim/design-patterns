import java.util.List;
import java.util.ArrayList;

public class AuditLog {
    // volatile: toda thread enxerga o objeto já completamente construído
    private static volatile AuditLog instance;

    private List<String> auditLogs;

    private AuditLog(){
        this.auditLogs = new ArrayList<>();
    }

    public static AuditLog getInstance(){
        if(instance == null){                 // 1ª verificação, sem trava: rápida quando o objeto já existe
            synchronized(AuditLog.class){     // trava: uma thread por vez daqui para dentro
                if(instance == null){         // 2ª verificação: outra thread pode ter criado enquanto esta esperava
                    instance = new AuditLog();
                }
            }
        }
        return instance;
    }

    // synchronized nos três métodos: duas threads nunca mexem na lista ao mesmo tempo
    public synchronized void register(String log){
        auditLogs.add(log);
    }

    public synchronized List<String> getRegistry(){
        return List.copyOf(auditLogs);
    }

    public synchronized void clear(){
        auditLogs.clear();
    }
}